package com.mashibing.Thread;


import java.util.concurrent.TimeUnit;

/**
 * @author : WLIN
 * @description : 模拟银行账号，对业务写加锁，对业务读不加锁
 * @date :2020/11/5
 */
public class Account {

    String userName;
    double balance;

    public static void main(String[] args){

        Account a = new Account();
        new Thread(()->a.setBalance("zhangsan",1000.00)).start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("账号余额："+a.getBalance("zhangsan"));

    }

    private  double getBalance(String zhangsan) {
        return  this.balance;
    }

    /**
     * 注释添加
     * @param userName
     * @param balance
     */
    private synchronized void setBalance(String userName, double balance) {

        this.userName = userName;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.balance = balance;

    }
}
