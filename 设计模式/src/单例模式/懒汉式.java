package ����ģʽ;

public class ����ʽ {
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);//�����true��˵������������ڴ��ַ��ͬ
    }
}

class Singleton2 {
    // 1.˽�л�������
    private Singleton2(){
    }
    // 2.�ڵ�������ڲ��������ʵ�����󣬴�ʵ������Ҳ�����Ǿ�̬��
    private static Singleton2 instance = null;
    //3.�ṩ�����ķ��������ص�����Ķ���
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}