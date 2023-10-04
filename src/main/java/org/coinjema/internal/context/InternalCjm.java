package org.coinjema.internal.context;

import org.coinjema.cjm.CjmContext;
import org.coinjema.cjm.ContextOriented;
import org.coinjema.internal.context.names.ResourceNameResolver;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.Function;

public class InternalCjm {
    static final Object DEFAULT_DEPENDENCY = new Object();
    static ScopedValue<ObjectSetterContextualizer> CONTEXTUALIZER = ScopedValue.newInstance();
    static ScopedValue<ConstructorContextualizer> CONSTRUCTOR_CONTEXTUALIZER = ScopedValue.newInstance();
    static final ReentrantLock globalSync = new ReentrantLock();

    public static void runWithContextualizer(Consumer<ObjectSetterContextualizer> func) {
        if (CONTEXTUALIZER.isBound()) func.accept(CONTEXTUALIZER.get());
        else
            ScopedValue.runWhere(CONTEXTUALIZER, new ObjectSetterContextualizer(), () -> func.accept(CONTEXTUALIZER.get()));

    }

    public static <T> T returnWithContextualizer(Function<ObjectSetterContextualizer, T> func) {
        if (CONTEXTUALIZER.isBound()) return func.apply(CONTEXTUALIZER.get());
        else {
            try {
                return ScopedValue.callWhere(CONTEXTUALIZER, new ObjectSetterContextualizer(), () -> func.apply(CONTEXTUALIZER.get()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static <T> T returnWithConstructorContextualizer(Function<ConstructorContextualizer, T> func) {
        if (CONSTRUCTOR_CONTEXTUALIZER.isBound()) return func.apply(CONSTRUCTOR_CONTEXTUALIZER.get());
        else {
            try {
                return ScopedValue.callWhere(CONSTRUCTOR_CONTEXTUALIZER, new ConstructorContextualizer(), () -> func.apply(CONSTRUCTOR_CONTEXTUALIZER.get()));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void contextualizeWithoutSave(final ContextOriented obj,
                                                final CjmContext context, final CjmContext base) {
        runWithContextualizer(contextualizer -> {
            contextualizer.contextualize(obj, context, base);
        });
    }

    public static Object captureDep(final Map<String, Object> values,
                                    ResourceNameResolver resolver, SpiceRack master) {
        return returnWithContextualizer(contextualizer -> contextualizer.captureDep(values, resolver, master));
    }

    public static SpiceRack findBaseContext(CjmContext base,
                                     CjmContext sub) {
        if (base == null && sub == null) {
            return SpiceRack.getRoot();
        } else if (base == null) {
            base = SpiceRack.getRoot().getContext();
        } else if (sub == null) {
            sub = SpiceRack.getRoot().getContext();
        }
        SpiceRack rack = null;
        CjmContext subParent = sub;
        while (subParent != null && rack == null) {
            CjmContext parent = base;
            while (parent != null && rack == null) {
                rack = SpiceRack.getInstance(new CjmContext(parent,
                        subParent));
                parent = parent.getParentContext();
            }
            subParent = subParent.getParentContext();
        }
        if (rack == null) {
            return SpiceRack.getRoot();
        }
        return rack;
    }

    public static ObjectSetterContextualizer getContextualizer() {
        if (CONTEXTUALIZER.isBound()) return CONTEXTUALIZER.get();
        else return new ObjectSetterContextualizer();
    }
}
