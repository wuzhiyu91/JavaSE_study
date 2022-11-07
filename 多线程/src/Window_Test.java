public class Window_Test {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w, "窗口1");
        Thread t2 = new Thread(w, "窗口2");
        Thread t3 = new Thread(w, "窗口3");

        //同时卖票
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window implements Runnable {

    private int ticket = 10;
    //创建一个 同步监视器，锁对象
    private Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {  //使用 synchronized 给操作共享数据的地方加锁
                //有票，可以出售
                if (ticket > 0) {

                    //出票操作，使用 sleep 模拟一下出票时间
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //获取当前线程对象的名字
                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);

                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}