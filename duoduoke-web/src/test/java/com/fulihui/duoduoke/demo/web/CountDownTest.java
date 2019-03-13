package com.fulihui.duoduoke.demo.web;


import org.junit.Test;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class CountDownTest {
    private static int num = 10000;
    private static CountDownLatch count = new CountDownLatch(num);


    static class ThreadMy implements Runnable {


        @Override
        public void run() {
            try {
                count.await();
                Socket socket = new Socket("192.168.1.41", 80);
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(60 * 60 * 1000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Test
    public void test01() {
        ThreadMy s = new ThreadMy();
        for (int i = 0; i < num; i++) {
            new Thread(s).start();
            count.countDown();
        }


    }
}
