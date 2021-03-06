package com.mashibing.Thread;


import java.util.concurrent.TimeUnit;

/**
 * @author : WLIN
 * @description : 模拟银行账号，对业务写加锁，对业务读不加锁
 * @date :2020/11/5
 */
public class Account {

    /**
     * 变量定义
     */
    String userName;//用户账户姓名
    double balance;//用户账户金额*****************8
    //----------**************----------
    /**
     *main方法
     * this is a test
     * 这是一个测试用例
     */
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
    
    private void getUser(){
    
    }
}
