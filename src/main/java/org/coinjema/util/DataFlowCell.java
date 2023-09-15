/*
 * Created on Jan 16, 2005
 *
 * This file is from the Coinjema project on sourceforge.net (http://coinjema.sourceforge.net)
 * This file is Public Domain software.
 */
package org.coinjema.util;

/**
 * @author mstover
 * 
 *         To change the template for this generated type comment go to Window -
 *         Preferences - Java - Code Generation - Code and Comments
 */
public class DataFlowCell<T> {

	private T value;

	/**
    * 
    */
	public DataFlowCell() {
		super();
	}

	public DataFlowCell(T v) {
		set(v);
	}

	/**
	 * @return Returns the value.
	 */
	public synchronized T get() {
		if (value == null) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		return value;
	}

	/**
	 * @param value
	 *            The value to set.
	 */
	public synchronized void set(T value) {
		if (this.value != null) {
			throw new UnsupportedOperationException(
					"A Data Flow Cell is a single assignment Object");
		}
		this.value = value;
		this.notify();
	}
}
