package com.demo.algorithm.Tread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tread01 extends Thread{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    long start1 = System.currentTimeMillis();
    int count1 = 0;

    public void fun1() {
        for(int i = 0 ; i < 1000000; i++) {
            Math.random();
        }
    }

    public void run() {
        Date date = new Date(start1);
        String startes = simpleDateFormat.format(date);

        System.out.println("start1:"+startes);


        while(true) {
            long end1 = System.currentTimeMillis();
            Date date1 = new Date(end1);
            String endtes = simpleDateFormat.format(date1);
            fun1();
            count1++;
            if ((end1 - start1) > 3000) {
                System.out.println("end1:"+endtes+"差值:"+(end1-start1));
                System.out.println("count1:"+count1);
                break;
            }
            //Thread.sleep(5000);
        }
    }
}
