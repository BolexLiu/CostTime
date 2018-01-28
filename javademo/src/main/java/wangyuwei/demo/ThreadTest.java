package wangyuwei.demo;

import wangyuwei.costtime.TimeCache;

/**
 * Created by bolex on 18/1/28.
 */

public class ThreadTest {

    public static void main(String[] args){


        new Thread(new Runnable() {
            @Override
            public void run() {
                long start1 = System.nanoTime();
                String dajipai = new String("dajipai");
                TimeCache.setStartTime(dajipai,start1);
                //do
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long end1 = System.nanoTime();
                TimeCache.setEndTime(dajipai,end1);
                System.out.println(TimeCache.getCostTime("dajipai"));
                System.out.println("实际Thread1:end========="+(end1-start1));

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                long start2 = System.nanoTime();
                String dajipai = new String("dajipai");
                TimeCache.setStartTime(dajipai,start2);
                //do
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                long end2 = System.nanoTime();
                TimeCache.setEndTime(dajipai,end2);
                System.out.println(TimeCache.getCostTime("dajipai"));
                System.out.println("实际Thread2:end========="+(end2-start2));

            }
        }).start();

    }


}
