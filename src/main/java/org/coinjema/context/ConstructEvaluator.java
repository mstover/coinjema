package org.coinjema.context;

import org.coinjema.context.eval.Evaluator;
import org.coinjema.context.source.Resource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConstructEvaluator implements Evaluator {
    @Override
    public Object evaluate(Resource source, Map<String, Object> params) {
        try (BufferedReader scriptBytes = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            String[] className = new String[]{null};
            List<String> dependencyNames = new ArrayList<>();
            scriptBytes.lines().forEach(line -> {
                if (className[0] == null) className[0] = line;
                else dependencyNames.add(line);
            });
            Class<?> clzz = Class.forName(className[0]);
            List<Object> dependencies = dependencyNames.stream().map(d -> Cjm.getDep(d)).collect(Collectors.toList());
            for (Constructor<?> declaredConstructor : clzz.getDeclaredConstructors()) {
                if(matches(dependencies,declaredConstructor.getParameters())) {
                    return declaredConstructor.newInstance(dependencies.toArray(new Object[dependencies.size()]));
                }
            }
            throw new RuntimeException("No constructor found in class " + clzz.getName()+" for parameters: " + dependencies);
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean matches(List<Object> dependencies, Parameter[] parameters) {
        return dependencies.size() == parameters.length;
    }
}
