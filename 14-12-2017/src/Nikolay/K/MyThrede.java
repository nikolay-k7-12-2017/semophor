package Nikolay.K;



public class MyThrede {



    String ss;
    private static volatile int x = 0;

    MyThrede(String ss) {
        this.ss = ss;
    }

    ReadBook readBook = new ReadBook();
    WrateFilee wrateFilee=new WrateFilee();

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("Thread started:::" + ss);
            readBook.readBook(ss);
            wrateFilee.wrateFile(readBook.countWord);

        }
    });
}
