package org.coinjema.context;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ReflectionCache {

    static Map<Class<?>, CoinjemaClassInfo> classInfoMap = new ConcurrentHashMap<>();

    static CoinjemaClassInfo getInfo(Class<?> cl) {
        return classInfoMap.computeIfAbsent(cl,cz -> new CoinjemaClassInfo(cz));
    }
}
