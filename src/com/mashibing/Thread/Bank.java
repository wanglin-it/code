package com.mashibing.Thread;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author : WLIN
 * @description :
 * @date :2020/11/4
 */
public class Bank {

    //账户数组
    private final double[] accounts;

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    /**
     *  构造函数
     * @param n accounts数组的长度
     * @param initialBalance 每个账户的钱款数
     * */
    public Bank(int n,double initialBalance){
        accounts=new double[n];

        Arrays.fill(accounts,initialBalance);
    }

    /**
     *  从一个账户向另一个账户转账
     * @param from 转出账户，对应数组中的元素
     * @param to 转入账户
     * @param amount 转账金额
     * */
    public synchronized void transfer(int from,int to,double amount){

        try {
            //转出账户的钱不够，结束
            if (accounts[from]<amount){

                return;
            }

            //对转出账户进行扣钱
            accounts[from]-=amount;
            //对转入账户进行加钱
            accounts[to]+=amount;

            System.out.printf(Thread.currentThread()+"从用户 %d 转出 %10.2f 到用户 %d",from,amount,to);
            System.out.println("\t当前银行所有用户的总余额："+getTotalBalance());

        }catch (Exception e){

        }finally {

        }
    }

    /**
     *  获取当前银行所有账户的余额之和
     * @return 银行的总余额
     * */
    public String getTotalBalance(){
        double sum=0;
        for (double a : accounts){
            sum+=a;
        }
        return decimalFormat.format(sum);
    }

    /**
     *  获取账户的数量，用于随机选取转入账户
     * @return 数组长度
     * */
    public int size(){
        return accounts.length;
    }
}
