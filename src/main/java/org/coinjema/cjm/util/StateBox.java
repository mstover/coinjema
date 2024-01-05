package org.coinjema.cjm.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicReference;

public abstract class StateBox<T> {

    private final AtomicReference<Tuple<T, Boolean>> ref = new AtomicReference<>(new Tuple(null, true));
    private final List<StateBox<?>> dependents = new Vector<>();

    public StateBox(StateBox<?>... parent) {
        for (StateBox<?> box : parent) {
            box.registerDependent(this);
        }
    }

    public T get() {
        return ref.updateAndGet(tup -> {
            if (!tup.b()) {
                return tup;
            } else {
                return new Tuple<>(internalGet(), false);
            }
        }).a();
    }

    public void registerDependent(StateBox<?> dep) {
        dependents.add(dep);
    }

    public void unregisterDependent(StateBox<?> dep) {
        dependents.remove(dep);
    }

    abstract protected T internalGet();

    public void markDirty() {
        Tuple<T, Boolean> t = ref.getAndUpdate(tup -> {
            if (tup.b()) {
                return tup;
            } else {
                return new Tuple<>(tup.a(), true);
            }
        });
        if (!t.b()) {
            notifyDependents();
        }
    }

    private void notifyDependents() {
        for (StateBox<?> dep : new ArrayList<>(dependents)) {
            dep.markDirty();
        }
    }
}
