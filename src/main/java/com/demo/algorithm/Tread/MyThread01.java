package com.demo.algorithm.Tread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyThread01 {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Tread01 tread01 = new Tread01();
        Tread02 tread02 = new Tread02();
        tread01.start();
        tread02.start();
        long start = System.currentTimeMillis();


        Date date = new Date(start);
        String startes = simpleDateFormat.format(date);
        System.out.println("当前时间" + "  " + startes);
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.execute(new Tread01());
        executor.execute(new Tread02());

        executor.shutdown();
        while (!executor.isTerminated()) {

        };

        long end = System.currentTimeMillis();
        Date date1 = new Date(end);
        String endRes = simpleDateFormat.format(date1);

        System.out.println("\n当前时间" + "  " + endRes);
        System.out.println("\n用时" + "  " + (end - start) / 1000 + "秒");

    }
}
