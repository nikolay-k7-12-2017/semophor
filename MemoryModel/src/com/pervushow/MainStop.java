package com.pervushow;

import java.util.Random;

public class MainStop {
    static int y = 0;
    static volatile boolean isStop = false;

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isStop){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(y);
                }
                System.out.println(Thread.currentThread().getName()
                                    + " is stopped!");
            }
        });

        Random random = new Random();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    y = random.nextInt(100);

                    if(y == 42){
                        System.out.println(Thread.currentThread().getName()
                                + " is stopped!");
                        isStop = true;
                        return;
                    }
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
