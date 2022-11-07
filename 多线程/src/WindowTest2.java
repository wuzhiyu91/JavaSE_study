public class WindowTest2 {
    public static void main(String[] args) {
        Window2 t1 = new Window2();
        Window2 t2 = new Window2();
        Window2 t3 = new Window2();

        t1.setName("����1");
        t2.setName("����2");
        t3.setName("����3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window2 extends Thread {
    private static int ticket = 10;
    private static Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            synchronized (obj) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(getName() + "����Ʊ��Ʊ��Ϊ��" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
