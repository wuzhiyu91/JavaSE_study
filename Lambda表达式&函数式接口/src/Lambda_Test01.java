import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.function.Consumer;

/**
 * Lambda���ʽ��ʹ��
 *  1��������(o1,o2) -> Integer.compare(o1,o2);
 *  2���﷨��
 *          -> : lambda������ �� ��ͷ������
 *          ->��� ��lambda�β��б���ʵ���ǽӿ��еĳ��󷽷����β��б�
 *          ->�ұ� ��lambda �� ��������Ҫ��д�ĳ��󷽷��ķ����壩
 *  3��lambda���ʽ��6��ʹ�����
 *  4��lambda���ʽ�ı��ʣ���Ϊ����ʽ�ӿڵ�ʵ���ࣨʵ������
 *      ֻ����һ�����󷽷��Ľӿڣ���Ϊ������ʽ�ӿڡ���
 *  5���ܽ᣺
 *      ��1��->��� ��lambda�β��б�Ĳ������Ϳ���ʡ�ԣ������ƶϣ������lambda�β��б�ֻ��һ��������������С���ţ�������ʡ��
 *      ��2��->�ұ� ��lambda�� Ӧ��ʹ��һ��{}���������lambda��ֻ��һ��ִ����䣨������return��䣩������ʡ��һ��{}��return�ؼ���
 *
 */

public class Lambda_Test01 {
    /**
     * �﷨��ʽһ���޲Σ��޷���ֵ
     */
    @Test
    public void test01(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("����������ʵ�ֽӿ�");
            }
        };
        r1.run();
        // �ӿ��е�����д�ķ����ǣ��޲Σ��޷���ֵ
        Runnable r2 = () -> {

            System.out.println("����lambda���ʽ");
        };
        r2.run();
    }

    /**
     * �﷨��ʽ����Lambda ��Ҫһ������������û�з���ֵ��
     */
    @Test
    public void test02(){
        // ����ʵ����
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("hello world");
        // lambda���ʽ
        Consumer<String> con1 = (String s) -> {
            System.out.println(s);
        };
        con1.accept("����lambda���ʽ");
    }

    /**
     * �﷨��ʽ�����������Ϳ���ʡ�ԣ���Ϊ���ɱ������ƶϵó�����Ϊ�������ƶϡ�
     */
    @Test
    public void test03(){
        // �������Ϳ����ɷ���ȷ�������Կ���ʡ�ԣ��Ż�����
//        Consumer<String> con = (String s) -> {
//            System.out.println(s);
//        };
//        con.accept("����lambda���ʽ");
        Consumer<String> con = (s) -> {
            System.out.println(s);
        };
        con.accept("����lambda���ʽ");
    }

    /**
     * �﷨��ʽ�ģ�Lambda ��ֻ��Ҫһ������ʱ��������С���ſ���ʡ��
     */
    @Test
    public void test04(){
        // ֻ��һ���������������ͺͣ�������ͬʱʡ��
//        Consumer<String> con = (String s) -> {
//            System.out.println(s);
//        };
//        con.accept("����lambda���ʽ");
        Consumer<String> con = s -> {
            System.out.println(s);
        };
        con.accept("����lambda���ʽ");
    }

    /**
     * �﷨��ʽ�壺Lambda ��Ҫ���������ϵĲ���������ִ����䣬���ҿ����з���ֵ
     */
    @Test
    public void test05(){
        // ����ʵ����
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("���㿪ʼ");
                return o1.compareTo(o2);
            }
        };
        System.out.println(com.compare(20, 10));
        // lambda���ʽ
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println("���㿪ʼ");
            return o1.compareTo(o2);
        };
        System.out.println(com.compare(20, 10));
    }

    /**
     * �﷨��ʽ������ Lambda ��ֻ��һ�����ʱ��return ����������У�������ʡ��
     */
    @Test
    public void test06(){
        // ����ʵ����
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            // �� Lambda ��ֻ��һ�����ʱ��return ����������У�������ʡ��
            }
        };
        System.out.println(com.compare(20, 10));
        // lambda���ʽ
        Comparator<Integer> com2 = (o1, o2) -> o1.compareTo(o2);
        System.out.println(com2.compare(20, 10));
    }
}
