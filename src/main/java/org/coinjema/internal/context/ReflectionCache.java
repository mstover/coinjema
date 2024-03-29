package org.coinjema.internal.context;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionCache {

    static Map<Class<?>, CjmClassInfo> classInfoMap = new ConcurrentHashMap<>();

    public static CjmClassInfo getInfo(Class<?> cl) {
        return classInfoMap.computeIfAbsent(cl,cz -> new CjmClassInfo(cz));
    }
}
