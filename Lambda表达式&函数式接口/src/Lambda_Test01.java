import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * Lambda表达式的使用
 *  1、举例：(o1,o2) -> Integer.compare(o1,o2);
 *  2、语法：
 *          -> : lambda操作符 或 箭头操作符
 *          ->左边 ：lambda形参列表（其实就是接口中的抽象方法的形参列表）
 *          ->右边 ：lambda 体 （就是需要重写的抽象方法的方法体）
 *  3、lambda表达式有6种使用情况
 *  4、lambda表达式的本质：作为函数式接口的实现类（实例）！
 *      只包含一个抽象方法的接口，称为【函数式接口】。
 *  5、总结：
 *      （1）->左边 ：lambda形参列表的参数类型可以省略（类型推断）；如果lambda形参列表只有一个参数，参数的小括号（）可以省略
 *      （2）->右边 ：lambda体 应该使用一对{}包裹：如果lambda体只有一条执行语句（可以是return语句），可以省略一堆{}和return关键字
 *
 */

public class Lambda_Test01 {
    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void test01(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("这是匿名类实现接口");
            }
        };
        r1.run();
        // 接口中的需重写的方法是：无参，无返回值
        Runnable r2 = () -> {

            System.out.println("这是lambda表达式");
        };
        r2.run();
    }

    /**
     * 语法格式二：Lambda 需要一个参数，但是没有返回值。
     */
    @Test
    public void test02(){
        // 匿名实现类
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello world");
        // lambda表达式
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("这是lambda表达式");
    }

    /**
     * 语法格式三：数据类型可以省略，因为可由编译器推断得出，称为“类型推断”
     */
    @Test
    public void test03(){
        // 数据类型可以由泛型确定，所以可以省略，优化如下
//        Consumer<String> con = (String s) -> {
//            System.out.println(s);
//        };
//        con.accept("这是lambda表达式");
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("这是lambda表达式");
    }

    /**
     * 语法格式四：Lambda 若只需要一个参数时，参数的小括号可以省略
     */
    @Test
    public void test04(){
        // 只有一个参数，数据类型和（）可以同时省略
//        Consumer<String> con = (String s) -> {
//            System.out.println(s);
//        };
//        con.accept("这是lambda表达式");
        Consumer<String> con = s -> {
            System.out.println(s);
        };
        con.accept("这是lambda表达式");
    }

    /**
     * 语法格式五：Lambda 需要两个或以上的参数，多条执行语句，并且可以有返回值
     */
    @Test
    public void test05(){
        // 匿名实现类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("计算开始");
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare(20, 10));
        // lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println("计算开始");
            return o1.compareTo(o2);
        };
        System.out.println(com.compare(20, 10));
    }

    /**
     * 语法格式六：当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
     */
    @Test
    public void test06(){
        // 匿名实现类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            // 当 Lambda 体只有一条语句时，return 与大括号若有，都可以省略
            }
        };
        System.out.println(com.compare(20, 10));
        // lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(20, 10));
    }
}
