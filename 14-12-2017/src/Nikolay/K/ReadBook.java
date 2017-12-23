package Nikolay.K;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

import static java.lang.Character.toUpperCase;


public class ReadBook {
    final Object lock =new Object();

    String string="страдание";
    char[] arrays= string.toCharArray();
    char[]  arraycount; // проверочный массив
    int countWord=0;
    String m;
    String v;

    public int getCountWord() {
        return countWord;
    }

    int count=0;


        public void readBook(String s) {
            synchronized (lock) {
                String fileName = "book//" + s;
                arraycount = new char[arrays.length];

                try {
                    FileInputStream is = new FileInputStream(fileName);
                    InputStreamReader is2 = new InputStreamReader(is, "windows-1251");
                    int i;
                    int j = 0;

                    while ((i = is2.read()) != -1) {
                        //  System.out.println("0"+arrays[j]+" "+(char)i );
                        if ((arrays[j] == (char) i) || (toUpperCase(arrays[j]) == (char) i)) {
                            //  if ((arrays[j] == (char) i) ) {
                            // System.out.println("1" + arrays[j] + " " + (char) i);
                            if (arraycount[j] == toUpperCase(arrays[j])) {             //проверка на заглавную букву
                                arraycount[j] = arrays[j];
                                if (j < 8) j++;
                            } else {
                                arraycount[j] = (char) i;
                                if (j < 8) j++;
                            }
                            if (Arrays.toString(arraycount).equals(Arrays.toString(arrays))) {
                                // System.out.println("gjgfk");
                                countWord++;
                                j = 0;
                                for (int k = 0; k < arraycount.length; k++) {
                                    arraycount[k] = 0;
                                }
                            }
                        } else {
                            j = 0;
                        }


                    }


                    System.out.println("название: " + s + " количество слов: " + countWord);


                    is2.close();

                    //   myEquals(linkedList);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }

}
