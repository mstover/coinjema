/*
 /*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

/*
 * This class appeared originally in the Apache JMeter project, and is used in Coinjema 
 * with modifications and improvements.  Although the Coinjema project is Public Domain 
 * software, please be aware of the source files with an Apache origin.
 */
package org.coinjema.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * The functor allows an easy way to setup dynamic methods that can be passed
 * around and efficiently invoked. The functor is easier to use than jdk Method
 * objects as it will figure out where to find the method that you want to
 * invoke. For instance, if you are calling a method with objects that extend
 * the class type of the arguments to that method, Functor will still find the
 * correct method to invoke.
 * 
 * @author mstover
 * 
 */
public class Functor<R> implements InvokableOn<R>, Callable<R>, Runnable {

	Object invokee;

	String methodName;

	Object[] args;

	Class[] types;

	transient volatile Method methodToInvoke;

	Functor<Method> methodFinder;

	Functor<R> post = null;

	Functor<?> pre;

	public Functor() {
	}

	public Functor(Object invokee, String methodName) {
		this(methodName);
		this.invokee = invokee;
	}

	public Functor(Object invokee, String methodName, Class... types) {
		this(invokee, methodName);
		this.types = types;
	}

	public Functor(String methodName) {
		this.methodName = methodName;
	}

	public Functor(String methodName, Class... types) {
		this(methodName);
		this.types = types;
	}

	public Functor(String methodName, Class[] types, Object[] args) {
		this(methodName, types);
		this.args = newArgs(args);
	}

	public Functor(String methodName, Object... args) {
		this(methodName);
		this.args = newArgs(args);
	}

	public Functor(String methodName, String oneArg) {
		this(methodName, (Object[]) new String[] { oneArg });
	}

	public Functor(Object invokee, String methodName, Object... args) {
		this(invokee, methodName);
		this.args = newArgs(args);
	}

	public Functor(Object invokee, String methodName, Object[] args,
			Class... types) {
		this(invokee, methodName, args);
		this.types = types;
	}

	public void run() {
		invoke();
	}

	public R invoke(Object invokee, Object... args) {
		// no sense calling this with a prechain - what would the prechain
		// provide?
		Object[] tempArgs = newArgs(args);
		types = FunctorHelp.setupTypes(types, tempArgs);
		try {
			if (methodToInvoke == null) {
				initMethodToInvoke(invokee);
			}
			Object res = methodToInvoke.invoke(invokee, tempArgs);
			if (post != null) {
				if (post.isMatchForInvokee(res)) {
					res = post.invokeOn(res);
				} else if (post.isMatchForArgs(res)) {
					res = post.invokeWith(res);
				}
			}
			return (R) res;
		} catch (Exception e) {
			throw new RuntimeException("Trying to invoke method: "
					+ getMethodName() + " on object: " + invokee
					+ " with arguments " + (tempArgs == null ? "none" : Arrays.asList(tempArgs)), e);
		}
	}

	public R call() {
		return invoke();
	}

	public R invokeOn(Object invokee) {
		if (pre != null) {
			if (pre.isMatchForInvokee(invokee)) {
				Object o = pre.invokeOn(invokee);
				if (args != null) {
					return invoke(o, args);
				} else if (this.invokee != null && isMatchForArgs(o)) {
					return invoke(this.invokee, o);
				} else if (isMatchFor(invokee, o)) {
					return invoke(invokee, o);
				} else {
					return invoke(o, new Object[0]);
				}
			} else {
				return invoke(invokee, pre.invoke());
			}
		} else {
			return invoke(invokee, args);
		}
	}

	public R invokeWith(Object... args) {
		if (pre != null) {
			if (pre.isMatchForArgs(args)) {
				Object o = pre.invokeWith(args);
				if (this.invokee != null && isMatchForArgs(o)) {
					return invoke(this.invokee, o);
				} else if (this.args != null) {
					return invoke(o, this.args);
				} else if (isMatchForArgs(args)) {
					return invoke(o, args);
				} else {
					return invoke(o, new Object[0]);
				}
			} else {
				return invoke(pre.invoke(), args);
			}
		} else {
			return invoke(invokee, args);
		}
	}

	public R invoke() {
		if (pre != null) {
			if (pre.isMatchForArgs(args)) {
				return invokeOn(pre.invokeWith(args));
			} else {
				return invoke(pre.invoke(), args);
			}
		} else {
			return invoke(invokee, args);
		}
	}

	boolean isMatchForArgs(Object... args) {
		if (methodToInvoke != null) {
			if (typesMatch(args, methodToInvoke.getParameterTypes())) {
				return true;
			} else {
				return false;
			}
		} else if (types != null) {
			if (typesMatch(args, types)) {
				return true;
			} else {
				return false;
			}
		} else if (invokee != null) {
			Class[] localTypes = FunctorHelp.setupTypes(types, args);
			if (createMethod(invokee, localTypes) != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	private boolean typesMatch(Object[] args, Class[] types) {
		int count = 0;
		for (Class type : types) {
			if (!type.isAssignableFrom(args[count++].getClass())) {
				return false;
			}
		}
		return true;
	}

	boolean isMatchFor(Object invokee, Object... args) {
		try {
			if (methodToInvoke != null) {
				if (methodToInvoke.getDeclaringClass().isAssignableFrom(
						invokee.getClass())) {
					return true;
				} else {
					return false;
				}
			} else {
				Class[] localTypes = FunctorHelp.setupTypes(types, args);
				if (createMethod(invokee, localTypes) != null) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {
			return false;
		}
	}

	boolean isMatchForInvokee(Object invokee) {
		try {
			if (this.invokee != null) {
				if (this.invokee.getClass()
						.isAssignableFrom(invokee.getClass())) {
					return true;
				} else {
					return false;
				}
			} else if (types != null) {
				if (methodToInvoke != null) {
					if (methodToInvoke.getDeclaringClass().isAssignableFrom(
							invokee.getClass())) {
						return true;
					} else {
						return false;
					}
				} else if (createMethod(invokee, types) != null) {
					return true;
				} else {
					return false;
				}
			} else if (args != null) {
				Class[] localTypes = FunctorHelp.setupTypes(types, args);
				if (createMethod(invokee, localTypes) != null) {
					return true;
				} else {
					return false;
				}
			} else if (invokee.getClass().getMethod(methodName, new Class[0]) != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	public Method createMethod(Object invokee, Class... types) {
		try {
			return invokee.getClass().getMethod(methodName, types);
		} catch (Exception e) {
			if (methodFinder == null) {
				methodFinder = new Functor<Method>(this, "createMethod",
						Object.class, Class[].class);
			}
			return FunctorHelp.getInvokable(invokee, types, methodFinder);
		}
	}

	/**
	 * @return Returns the methodName.
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * If a post chain is added to a functor, then the chained functor will be
	 * run on the resulting object of this functor.
	 * <p>
	 * Ie: Assume, Functor A, Functor B,Functor C. <br>
	 * <b>Given:</b> A.postChain(B).postChain(C) <br>
	 * A.invokeOn(myObj) <b>is equivalent to</b>
	 * C.invokeOn(B.invokeOn(A.invokeOn(myObj))) <br>
	 * A.invokeWith(objArray) <b>is equivalent to</b>
	 * C.invokeOn(B.invokeOn(A.invokeWith(objArray)))
	 * 
	 * @param f
	 */
	public Functor<R> postChain(Functor<R> f) {
		if (post != null) {
			post.postChain(f);
		} else {
			post = f;
		}
		return this;
	}

	public Functor<R> postChain(String methodName) {
		return postChain(new Functor(methodName));
	}

	public Functor<R> postChain(Object invokee, String methodName) {
		return postChain(new Functor(invokee, methodName));
	}

	/**
	 * If a pre chain is added to a functor, then the chained functor will be
	 * run and the results passed into this functor to invoke on.
	 * <p>
	 * Ie: Assume, Functor A, Functor B,Functor C. <br>
	 * <b>Given:</b> A.preChain(B).preChain(C) <br>
	 * A.invoke() <b>is equivalent to</b> A.invoke(B.invoke(C.invoke()))<br>
	 * A.invokeWith(objArray) <b>is equivalent to</b>
	 * A.invokeWith(B.invoke(C.invoke()),objArray)<br>
	 * A.invokeOn(invokee) <b>is equivalent to</b> A.invokeOn(invokee,new
	 * Object[]{B.invoke(C.invoke())})
	 * 
	 * @param f
	 */
	public Functor<R> preChain(Functor<?> f) {
		if (pre != null) {
			pre.preChain(f);
		} else {
			pre = f;
		}
		return this;
	}

	public Functor preChain(String methodName) {
		return preChain(new Functor(methodName));
	}

	public Functor preChain(String methodName, Object... args) {
		return preChain(new Functor(methodName, args));
	}

	public Functor preChain(Object invokee, String methodName) {
		return preChain(new Functor(invokee, methodName));
	}

	public Functor preChain(Object invokee, String methodName, Object... args) {
		return preChain(new Functor(invokee, methodName, args));
	}

	private boolean noNullValue(Object[] values) {
		for (Object v : values) {
			if (v == null) {
				return false;
			}
		}
		return true;
	}

	private Object[] newArgs(Object... args) {
		if (this.args == args) {
			return this.args;
		} else if (this.args == null) {
			return args;
		} else if (args == null) {
			if (this.args == null) {
				return new Object[0];
			} else {
				return this.args;
			}
		} else if (noNullValue(this.args)) {
			return this.args;
		} else if (this.args.length == args.length) {
			Object[] newArgs = new Object[args.length];
			for (int i = 0; i < this.args.length; i++) {
				if (this.args[i] == null) {
					newArgs[i] = args[i];
				} else {
					newArgs[i] = this.args[i];
				}
			}
			return newArgs;
		} else {
			int count = 0;
			List<Object> newArgs = new LinkedList<Object>();
			for (int i = 0; i < this.args.length; i++) {
				if (this.args[i] == null && count < args.length) {
					newArgs.add(args[count++]);
				} else {
					newArgs.add(this.args[i]);
				}
			}
			while (count < args.length) {
				newArgs.add(args[count++]);
			}
			return newArgs.toArray(new Object[newArgs.size()]);
		}
	}

	protected synchronized void initMethodToInvoke(Object invokee) {
		if (methodToInvoke == null) {
			methodToInvoke = createMethod(invokee, types);
		}
	}
}
