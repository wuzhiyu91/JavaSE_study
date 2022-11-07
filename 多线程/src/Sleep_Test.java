/**
 * 关于线程的sleep方法
 *  static void sleep(long millis)；
 * @Param millis 毫秒
 * 作用：让当前线程进入”阻塞状态“，放弃占有CPU时间片，让给其他线程使用。在指定的millitime毫秒时间内，当前线程是阻塞状态。
 *      millitime阻塞时间结束后，当前线程重新进入就”就绪状态“
 * Threa.sleep（）方法可以做到这种效果：间隔特定的时间，去执行一段特定的代码，每隔多久执行一次
 * 注意：Threa.sleep（）方法，出现在哪个线程中，就是让哪个线程进入休眠。
 */
public class Sleep_Test {
    public static void main(String[] args) throws InterruptedException {
        // 让当前主线程进入休眠，睡眠5秒
//        Thread.sleep(1000*5);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        //当前线程睡眠0.5秒
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("==========");
        }
    }
}

