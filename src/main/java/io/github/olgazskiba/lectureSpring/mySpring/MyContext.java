package io.github.olgazskiba.lectureSpring.mySpring;

import io.github.olgazskiba.lectureSpring.mySpring.bean.Humanable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class MyContext {

    private MyContext(){

    }
    public static Map<String, Object> instances = new ConcurrentHashMap<>();

    static {
        try (Stream<Path> paths = Files.walk(Paths.get("./target"))) {
            List<String> resultList = paths
                    .filter(a -> a.getFileName().toString().contains(".class"))
                    .map(a -> a.toString())
                    .map(a -> a.substring(a.indexOf("classes/") + "classes/".length(), a.indexOf(".class")))
                    .map(a -> a.replaceAll("/", "."))
                    .collect(Collectors.toList());

            System.out.println("Context loading ... ");

            for (String className : resultList) {
                try {
                    Class<?> clazz = Class.forName(className);
                    instances.put(className.substring(className.lastIndexOf(".") + 1), clazz.newInstance());
                    System.out.println("\tcreate instance of: " + clazz);
                } catch (Exception ex) {
                    // no such class exception, just go on
                }
            }
        } catch (Exception ex) {

        }
        System.out.println("Context loaded ... ");
    }

    public static Humanable getHuman(String humanType){
        if(instances.get(humanType) != null && instances.get(humanType) instanceof Humanable) {
            return (Humanable) instances.get(humanType);
        } else {
            return null;
        }
    }
}
