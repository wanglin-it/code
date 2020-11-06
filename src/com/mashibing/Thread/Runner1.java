package com.mashibing.Thread;

/**
 * @author : WLIN
 * @description : test
 * @date :2020/11/4
 */
public class Runner1 extends Thread{

    public void run(){
        for (int i=0;i<100;i++){
            System.out.println("Runner1:-------"+i);
        }
    }
}
