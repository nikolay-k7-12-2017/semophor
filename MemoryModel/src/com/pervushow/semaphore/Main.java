package com.pervushow.semaphore;

public class Main {
    public static void main(String[] args) {

        Supplier supplier = new Supplier();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start potok1");
                    supplier.supply(1,0,1);
            }

        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start potok2");
                    supplier.supply(5,5,7);
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                    System.out.println("start potok3");
                    supplier.supply(0,0,9);
            }
        });

        thread.start();
        thread2.start();
        thread3.start();
    }
}
