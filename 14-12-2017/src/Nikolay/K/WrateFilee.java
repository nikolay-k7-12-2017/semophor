package Nikolay.K;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

public class WrateFilee {

    AtomicInteger atomicInteger = new AtomicInteger(0);

    int a;

    String fileName = "employe.txt";

    WrateFilee(int a) {
        this.a = a;
    }

    WrateFilee() {
    }

    // записываем объекты в файл
    public void wrateFile(int a) {
        try {
            FileOutputStream os = new FileOutputStream(fileName,true);

            DataOutputStream oos = new DataOutputStream(os);

            oos.writeInt(a);
            oos.writeUTF(" ");
          //  System.out.println(a + " ");

            // закрываем потоки
            // достаточно закрыть только поток-надстройку

            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readElement() {
        System.out.println("Read objects:");

        try {
            FileInputStream is = new FileInputStream(fileName);
            DataInputStream ois = new DataInputStream(is);
            int i = 0;
          //  System.out.println(ois.available());
            while (ois.available()>i) { // Считываем  объекты
                System.out.print(ois.readInt());
                System.out.print(ois.readUTF());
                i++;

            }
            System.out.print(ois.readInt());
            System.out.print(ois.readUTF());

            ois.close();
            System.out.println(" ");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void wrateNull() {
        try {
            FileOutputStream os = new FileOutputStream(fileName);

            DataOutputStream oos = new DataOutputStream(os);

            // закрываем потоки
            // достаточно закрыть только поток-надстройку

            oos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
