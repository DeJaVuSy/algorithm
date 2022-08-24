package com.demo.algorithm.Tread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tread02 extends Thread{

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    int count2 = 0;
    long start2 = System.currentTimeMillis();

    public void fun2(){
        for(int i = 0 ; i < 10000; i++) {
            Math.random();
        }

    }
    public void run() {
        System.out.println("start2:"+start2);
        Date date = new Date(start2);
        String startes = simpleDateFormat.format(date);
        while(true) {
            fun2();
            count2++;
            long end2 = System.currentTimeMillis();
            if ((end2 - start2) > 3000 ) {
                System.out.println("end2:"+startes+"差值:"+(end2-start2));
                System.out.println("count2:"+count2);
                break;
            }
            //Thread.sleep(7000);
        }
        /*try {
            for (int i = 0; i < 60; i++) {
                Thread.sleep(1000);
                System.out.println("Thread02执行");
            }
            Thread.sleep(1000);
            System.out.println("Thread02执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
