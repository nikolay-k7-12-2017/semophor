package com.pervushow.semaphore;

public class Supplier {
    Object lock=new Object();
    private GunWarehouse gunWarehouse = new GunWarehouse();
    private KnifeWarehouse knifeWarehouse = new KnifeWarehouse();
    private BFGWarehouse bfgWarehouse = new BFGWarehouse();

    public void supply(int guns, int knifes, int bfgs){
        for (int i=0;i<guns;i++){
            synchronized (lock){
                gunWarehouse.add();
                System.out.println("gunWarehouse "+(i+1));
            }
        }
        for (int j=0;j<knifes;j++){
            synchronized (lock){
                knifeWarehouse.add();
                System.out.println("knifeWarehouse "+(j+1));
            }
        }

        for (int k=0;k<bfgs;k++){
            synchronized (lock){
                bfgWarehouse.add();
                System.out.println("bfgWarehouse "+(k+1));
            }
        }


    }
}
