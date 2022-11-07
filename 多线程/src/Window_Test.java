public class Window_Test {
    public static void main(String[] args) {
        Window w = new Window();

        Thread t1 = new Thread(w, "����1");
        Thread t2 = new Thread(w, "����2");
        Thread t3 = new Thread(w, "����3");

        //ͬʱ��Ʊ
        t1.start();
        t2.start();
        t3.start();
    }
}
class Window implements Runnable {

    private int ticket = 10;
    //����һ�� ͬ����������������
    private Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {  //ʹ�� synchronized �������������ݵĵط�����
                //��Ʊ�����Գ���
                if (ticket > 0) {

                    //��Ʊ������ʹ�� sleep ģ��һ�³�Ʊʱ��
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //��ȡ��ǰ�̶߳��������
                    System.out.println(Thread.currentThread().getName() + ":��Ʊ��Ʊ��Ϊ��" + ticket);

                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}