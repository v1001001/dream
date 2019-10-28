package com.dream.controller.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaThreadPool {


    public static void main(String[] args) throws InterruptedException {
        fixedPool();
    }

    public static void fixedPool() throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        for (int i = 0; i < 10; i++) {

            Thread.sleep(1000);
            final int index = i;

            executor.execute(() -> {
                try {
                    Thread.sleep(2 * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  " + index);
            });
        }
        executor.shutdown();
    }
}
