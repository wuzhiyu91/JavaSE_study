public class Thread_Test01 {
    public static void main(String[] args) {
        // 这里是分支栈，这里的代码属于主线程，在栈中运行
        //创建一个分支线程对象
        Thread t = new MyThread();
//        t.run();*注意*：手动调用run()方法，那么就只是普通方法，不会启动线程，不会分配新的分支栈。（这种方式就是单线程）

        //启动线程
        /*  start方法的作用：
            启动线程，为分支线程开启一个新的栈空间，只要新的栈空间开出来，strat()方法就结束，分支线程进入”就绪状态“。
            分支线程进入”就绪状态“后，就具有抢占CPU时间片的权力；
            当分支线程抢占到CPU时间片后，
            JVM会自动调用run()方法，并且run()方法压栈在分支栈的底部
            run方法在分支栈的底部，main方法在主栈的底部。
         */
        t.start();
        // 这里的代码还是运行在主线程中
        for (int i = 0; i <1000 ; i++) {
            System.out.println("主线程-------------->"+i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run(){
        // 编写程序，这段程序运行在分支线程中（分支栈）
        for (int i = 0; i <1000 ; i++) {
            System.out.println("分支栈---->"+i);
        }
    }
}