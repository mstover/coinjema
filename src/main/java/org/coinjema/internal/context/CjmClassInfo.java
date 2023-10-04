package org.coinjema.internal.context;

import org.coinjema.cjm.CjmObject;

public class CjmClassInfo {

    public final Class<?> clzz;
    public final String simpleName;

    public CjmClassInfo(Class<?> clzz) {
        this.clzz = clzz;
        this.simpleName = getSimpleName(clzz);

    }

    private String getSimpleName(final Class<?> clazz) {
        CjmObject ann = findObjectAnnotation(clazz);
        if (ann != null && ann.type().length() > 0)
            return ann.type();
        else
            return clazz.getSimpleName();
    }

    private CjmObject findObjectAnnotation(Class<?> clazz) {
        Class parent = clazz;
        CjmObject ann = null;
        while (ann == null && parent != Object.class) {
            ann = (CjmObject) parent.getAnnotation(CjmObject.class);
            if (ann == null)
                parent = parent.getSuperclass();
        }
        return ann;
    }
}
