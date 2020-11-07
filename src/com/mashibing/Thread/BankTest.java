package com.mashibing.Thread;

/**
 * @author : WLIN
 * @description :
 * @date :2020/11/4
 */
public class BankTest {

    //模拟100个账户
    public static final int ACCOUNTS_SIZE=100;
    //假设每个账户1000元，那么并发安全的情况下，银行的总余额应该始终是100000元
    public static final double INIT_BALANCE=1000;
    //假设转账金额的上限是1000元
    public static final double MAX_AMOUNT=1000;
    //休眠时间
    public static final int DELAY=10;

    /**
     * this is a main
     * @param args
     */
    public static void main(String[] args) {
        //实例化一个有100个账户、每个账户初始余额为1000元的银行
        Bank bank=new Bank(ACCOUNTS_SIZE,INIT_BALANCE);

        //开启100个线程
        for (int i = 0; i < ACCOUNTS_SIZE; i++) {
            //转出账户
            int fromAccount=i;

            //构造线程
            Runnable runnable=() ->{
                try {
                    while (true){
                        //随机获取一个转入账户
                        int toAccount=(int)(bank.size()*Math.random());
                        //随机获取转账金额
                        double amount=MAX_AMOUNT*Math.random();
                        //执行转账
                        bank.transfer(fromAccount,toAccount,amount);
                        //模拟耗时
                        Thread.sleep((long)(DELAY*Math.random()));
                    }
                }catch (InterruptedException e){

                }
            };
            Thread thread=new Thread(runnable);
            thread.start();
        }
    }
}
