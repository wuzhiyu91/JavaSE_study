package 单例模式;

public class 懒汉式 {
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);//输出：true，说明两个对象的内存地址相同
    }
}

class Singleton2 {
    // 1.私有化构造器
    private Singleton2(){
    }
    // 2.在单例类的内部单例类的实例对象，此实例对象也必须是静态的
    private static Singleton2 instance = null;
    //3.提供公共的方法，返回单例类的对象
    public static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}