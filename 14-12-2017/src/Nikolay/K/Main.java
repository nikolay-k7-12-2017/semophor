package Nikolay.K;


import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class Main {

    public static void main(String[] args) {

        final Object lock=new Object();
        WrateFilee wrateFilee=new WrateFilee();
        wrateFilee.wrateNull();
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        ReadWriteLock readWriteLock=new ReentrantReadWriteLock();
        Lock readLock= readWriteLock.writeLock();

        String[] fileName=new String[11];
        MyThrede[] myThrede=new MyThrede[10];
         fileName[1] = "Анна Каренина.txt";
         fileName[2] = "Братья Карамазовы.txt";
         fileName[3] = "Война и мир(том 1 и 2).txt";
         fileName[4] = "Война и мир (том 3 и 4).txt";
         fileName[5] = "Герой нашего времени.txt";
         fileName[6] = "Горе от ума.txt";
         fileName[7] = "Идиот.txt";
         fileName[8]= "Капитанская дочка.txt";
         fileName[9] = "Мёртвые души.txt";
         fileName[10] = "Тарас Бульба.txt";

        for (int i=0;i<10;i++) {
           myThrede[i]= new MyThrede(fileName[i+1]);
        }



            for (int i=0;i<10;i++) {
               // readLock.lock();
                executorService.submit(myThrede[i].thread);
               // readLock.unlock();
            }
            executorService.shutdown();

            synchronized (lock) {
                try {
                    lock.wait(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.lock();
                wrateFilee.readElement();
                readLock.unlock();
            }

    }


}
