/**
 * �����̵߳�sleep����
 *  static void sleep(long millis)��
 * @Param millis ����
 * ���ã��õ�ǰ�߳̽��롱����״̬��������ռ��CPUʱ��Ƭ���ø������߳�ʹ�á���ָ����millitime����ʱ���ڣ���ǰ�߳�������״̬��
 *      millitime����ʱ������󣬵�ǰ�߳����½���͡�����״̬��
 * Threa.sleep��������������������Ч��������ض���ʱ�䣬ȥִ��һ���ض��Ĵ��룬ÿ�����ִ��һ��
 * ע�⣺Threa.sleep�����������������ĸ��߳��У��������ĸ��߳̽������ߡ�
 */
public class Sleep_Test {
    public static void main(String[] args) throws InterruptedException {
        // �õ�ǰ���߳̽������ߣ�˯��5��
//        Thread.sleep(1000*5);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        //��ǰ�߳�˯��0.5��
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

