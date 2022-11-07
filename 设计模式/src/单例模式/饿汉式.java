package 单例模式;

public class 饿汉式 {
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);//输出：true，说明两个对象的内存地址相同
    }
}
/*饿汉式*/
class Singleton{
    // 1.私有化类的构造器,私有化构造器的目的：不能用new操作符在类的外部产生类的对象
    private Singleton(){
    }
    // 2.在单例类的内部单例类的实例对象，此实例对象也必须是静态的
    private static Singleton instance = new Singleton();

    // 3.提供公共的方法，返回单例类的对象
    public static Singleton getInstance() {
        return instance;
    }
}