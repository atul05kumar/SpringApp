package com.atul;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(AppConfig.class);
        String abc = "Atul";
        abc.length();
        int [] arr = new int[5];
        int size = arr.length;
        Map<String, String> myMap = new HashMap<>();
        for(String key : myMap.keySet()) {
            System.out.printf(myMap.get(key));
            abc.charAt(0);
            char[] charArray = abc.toCharArray();
            Arrays.sort(new int[] {4, 56, 7, 2});
        }

    }
}
