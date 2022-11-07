public class synchronized_Test01 {
    public static void main(String[] args) {
        // 创建账户对象（只创建1个）
        Account act001 = new Account(10000, "act001");
        // 创建2个线程
        AccountThread t1 = new AccountThread(act001);
        AccountThread t2 = new AccountThread(act001);

        // 设置线程名
        t1.setName("t1");
        t1.setName("t2");
        // 启动线程取款
        t1. start();
        t2.start();
    }
}

/*
    账户类
 */
class Account {
    // 余额
    private double balance = 500;
    // 账号
    private String actno;

    // 取款方法
    public void withdraw(double money) {
        // 以下这几行代码必须是线程排队的，不能并发
        // 一个线程把这里的代码全部执行结束后，另一个线程才能进来
        /*
            线程同步机制的语法是
                synchronized（）{
                    线程同步的代码块
                }
             synchronized后面小括号中的这个”数据“是非常关键的
             这个数据必须是多线程共享的数据！！！
             （）中写什么？那要看想让哪些线程同步
             假设t1、t2、t3、t4、t5,有5个线程，你只希望t1、t2、t3排队，
             t4、t5不排队，怎么办？你一定要在（）中写一个t1、t2、t3共享的对象，
             而这个对象对于t4、t5来说是不共享的
             例子中的共享对象是：账户对象
             账户对象是共享的，那么this就指代当前账户对象！
             不一定是this,这里只要是多线程共享的对象（成员变量）就行。
             在java语言中，任何一个对象都有”一把锁“，其实这把锁就是标记（只是把它叫做”锁“）
             100个对象，100把锁。1个对象是1 把锁
             以下代码的执行原理是：
                1、假设t1和t2线程并发，开始执行以下代码的时候，肯定有一个先一个后
                2、假设t1先执行了，遇到了synchronized，这个时候自动找”后面共享对象“的对象锁，
                找到之后，并占有这把锁，然后执行同步代码块中的程序，在执行过程中一直都是占有这把
                锁的。指导同步代码块代码结束，这把锁才会释放
                3、假设t1已经占有这把锁，此时t2也遇到synchronized关键字，也会去占有后面共享对象
                的这把锁，结果这把锁被t1占有，t2只能在同步代码块外面等待t1的结束，直到t1把同步代码块
                执行结束了，t1会归还这把锁，此时t2终于等到这把锁，然后t2占有这把锁之后，进入同步代码块执行程序。
                这样就达到了线程排队执行

         */
        synchronized (this) {
            // 取款之前的余额
            double before = this.getBalance();
            //取款之后的余额
            double after = before - money;
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 更新余额
            this.setBalance(after);
        }

    }

    public Account() {
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Account(double balance, String actno) {
        this.balance = balance;
        this.actno = actno;
    }
}

/*
    模拟账户的线程
 */
class AccountThread extends Thread {
    // 两个线程必须共享同一个账户对象
    private Account account;

    // 通过构造方法传递过来账户对象
    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        // run方法的执行模拟取款操作
        // 假设取款5000
        double money = 5000;
        // 取款
        //多线程并发执行这个方法
        account.withdraw(money);
        System.out.println("账户" + account.getActno() + "取款成功，余额" + account.getBalance());
    }
}
