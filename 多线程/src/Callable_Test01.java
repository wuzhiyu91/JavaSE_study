import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//FutureTask是java的JUC剥下的，属于java的并发包
//Task"任务";concurrent"并发"；FutureTask“未来任务”
/**
 * 实现线程的第三种方式：实现Callable接口
 * public interface Callable<V>
 */
public class Callable_Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 第一步：创建一个“未来任务类”对象
        FutureTask task = new FutureTask(new Callable() {//匿名内部类的方式创建Callable接口的实现类
            @Override
            public Object call() throws Exception {// call()方法就相当于run方法，call()方法有返回值
                //模拟线程执行
                System.out.println("call method begin");
                Thread.sleep(1000*5);
                System.out.println("call method begin");
                int a = 100,b=200;
                return a+b;
            }
        });
        // 第二步：创建线程对象,通过Thread()构造方法，传入FutureTask对象
        Thread t = new Thread(task);
        // 启动线程
        t.start();
        // 在main主线程中，怎么获取t线程返回的结果？
        /*get()方法的执行会导致当前线程的阻塞*/
        Object obj = task.get();
        System.out.println("分支线程t的执行结果"+obj);
        //get()方法是为了拿到另一个线程（t）的返回值，另一个线程的执行是需要时间的
        // 所以main主线程会被阻塞需要等待t线程的结束才会执行主线程中以下的代码
        System.out.println("主线程：hello world");
    }
}
