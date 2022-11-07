import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
//FutureTask��java��JUC���µģ�����java�Ĳ�����
//Task"����";concurrent"����"��FutureTask��δ������
/**
 * ʵ���̵߳ĵ����ַ�ʽ��ʵ��Callable�ӿ�
 * public interface Callable<V>
 */
public class Callable_Test01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // ��һ��������һ����δ�������ࡱ����
        FutureTask task = new FutureTask(new Callable() {//�����ڲ���ķ�ʽ����Callable�ӿڵ�ʵ����
            @Override
            public Object call() throws Exception {// call()�������൱��run������call()�����з���ֵ
                //ģ���߳�ִ��
                System.out.println("call method begin");
                Thread.sleep(1000*5);
                System.out.println("call method begin");
                int a = 100,b=200;
                return a+b;
            }
        });
        // �ڶ����������̶߳���,ͨ��Thread()���췽��������FutureTask����
        Thread t = new Thread(task);
        // �����߳�
        t.start();
        // ��main���߳��У���ô��ȡt�̷߳��صĽ����
        /*get()������ִ�лᵼ�µ�ǰ�̵߳�����*/
        Object obj = task.get();
        System.out.println("��֧�߳�t��ִ�н��"+obj);
        //get()������Ϊ���õ���һ���̣߳�t���ķ���ֵ����һ���̵߳�ִ������Ҫʱ���
        // ����main���̻߳ᱻ������Ҫ�ȴ�t�̵߳Ľ����Ż�ִ�����߳������µĴ���
        System.out.println("���̣߳�hello world");
    }
}
