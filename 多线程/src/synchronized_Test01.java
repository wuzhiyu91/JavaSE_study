public class synchronized_Test01 {
    public static void main(String[] args) {
        // �����˻�����ֻ����1����
        Account act001 = new Account(10000, "act001");
        // ����2���߳�
        AccountThread t1 = new AccountThread(act001);
        AccountThread t2 = new AccountThread(act001);

        // �����߳���
        t1.setName("t1");
        t1.setName("t2");
        // �����߳�ȡ��
        t1. start();
        t2.start();
    }
}

/*
    �˻���
 */
class Account {
    // ���
    private double balance = 500;
    // �˺�
    private String actno;

    // ȡ���
    public void withdraw(double money) {
        // �����⼸�д���������߳��Ŷӵģ����ܲ���
        // һ���̰߳�����Ĵ���ȫ��ִ�н�������һ���̲߳��ܽ���
        /*
            �߳�ͬ�����Ƶ��﷨��
                synchronized����{
                    �߳�ͬ���Ĵ����
                }
             synchronized����С�����е���������ݡ��Ƿǳ��ؼ���
             ������ݱ����Ƕ��̹߳�������ݣ�����
             ������дʲô����Ҫ��������Щ�߳�ͬ��
             ����t1��t2��t3��t4��t5,��5���̣߳���ֻϣ��t1��t2��t3�Ŷӣ�
             t4��t5���Ŷӣ���ô�죿��һ��Ҫ�ڣ�����дһ��t1��t2��t3����Ķ���
             ������������t4��t5��˵�ǲ������
             �����еĹ�������ǣ��˻�����
             �˻������ǹ���ģ���ôthis��ָ����ǰ�˻�����
             ��һ����this,����ֻҪ�Ƕ��̹߳���Ķ��󣨳�Ա���������С�
             ��java�����У��κ�һ�������С�һ����������ʵ��������Ǳ�ǣ�ֻ�ǰ���������������
             100������100������1��������1 ����
             ���´����ִ��ԭ���ǣ�
                1������t1��t2�̲߳�������ʼִ�����´����ʱ�򣬿϶���һ����һ����
                2������t1��ִ���ˣ�������synchronized�����ʱ���Զ��ҡ����湲����󡰵Ķ�������
                �ҵ�֮�󣬲�ռ���������Ȼ��ִ��ͬ��������еĳ�����ִ�й�����һֱ����ռ�����
                ���ġ�ָ��ͬ���������������������Ż��ͷ�
                3������t1�Ѿ�ռ�����������ʱt2Ҳ����synchronized�ؼ��֣�Ҳ��ȥռ�к��湲�����
                �������������������t1ռ�У�t2ֻ����ͬ�����������ȴ�t1�Ľ�����ֱ��t1��ͬ�������
                ִ�н����ˣ�t1��黹���������ʱt2���ڵȵ��������Ȼ��t2ռ�������֮�󣬽���ͬ�������ִ�г���
                �����ʹﵽ���߳��Ŷ�ִ��

         */
        synchronized (this) {
            // ȡ��֮ǰ�����
            double before = this.getBalance();
            //ȡ��֮������
            double after = before - money;
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // �������
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
    ģ���˻����߳�
 */
class AccountThread extends Thread {
    // �����̱߳��빲��ͬһ���˻�����
    private Account account;

    // ͨ�����췽�����ݹ����˻�����
    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        // run������ִ��ģ��ȡ�����
        // ����ȡ��5000
        double money = 5000;
        // ȡ��
        //���̲߳���ִ���������
        account.withdraw(money);
        System.out.println("�˻�" + account.getActno() + "ȡ��ɹ������" + account.getBalance());
    }
}
