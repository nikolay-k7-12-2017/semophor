package com.pervushow;

import java.util.HashMap;
import java.util.Map;

public class MainExperiment {
    static Map<String, String> stringMap = new HashMap<>();
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                for(int i = 0; i < 1000; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (stringMap) {
                        stringMap.put(i+"", i + "");
                    }
                    System.out.println("Iter " + i + " lenght " + stringMap.size());
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stringMap = new HashMap<>();
            }
        });

        thread.start();
        thread1.start();
    }
}
