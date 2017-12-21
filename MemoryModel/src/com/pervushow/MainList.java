package com.pervushow;

public class MainList {
    private static volatile int value = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new Changer().start();
    }

    static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local = value;
            while (local < 5){
                if(local != value){
                    System.out.println("Changed for " + local
                                       + " and global " + value);
                    local = value;
                }
            }
        }
    }

    static class Changer extends Thread {
        @Override
        public void run() {
            int local = value;
            while (value < 5){
                System.out.println("Updating to " + local);
                value = ++local;

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
