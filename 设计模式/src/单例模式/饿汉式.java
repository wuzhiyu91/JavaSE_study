package ����ģʽ;

public class ����ʽ {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);//�����true��˵������������ڴ��ַ��ͬ
    }
}
/*����ʽ*/
class Singleton{
    // 1.˽�л���Ĺ�����,˽�л���������Ŀ�ģ�������new������������ⲿ������Ķ���
    private Singleton(){
    }
    // 2.�ڵ�������ڲ��������ʵ�����󣬴�ʵ������Ҳ�����Ǿ�̬��
    private static Singleton instance = new Singleton();

    // 3.�ṩ�����ķ��������ص�����Ķ���
    public static Singleton getInstance() {
        return instance;
    }
}