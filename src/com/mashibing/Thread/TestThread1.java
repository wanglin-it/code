package com.mashibing.Thread;

/**
 * @author : WLIN
 * @description : 多线程
 * @date :2020/11/3
 */
public class TestThread1{

    public static void main(String[] args){
        Runner1 runner1 = new Runner1();

        System.out.println("state get---"+runner1.getState());


        runner1.start();

        try {
            runner1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i=0;i<100;i++){
            System.out.println("Main Thread-------"+i);
        }
    }

}
