package Map;

import Set.TreeSet_Test;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/*
    1.TreeSet���ϵײ�ʵ����һ��TreeMap
    2.TreeMap���ϵײ���һ��������
    3.�ŵ�TreeSet�����е�Ԫ�أ���ͬ�ڷŵ�TreeMap���ϵ�key������
    4.TreeSet�����е�Ԫ�أ����򲻿��ظ������ǿ��԰���Ԫ�صĴ�С˳���Զ����򣬳�Ϊ�����򼯺�

 */
public class TreeMap_Test01 {
    @Test
    public void test_treeSet() {
        // ����һ��TreeSet����
        TreeSet<String> ts = new TreeSet<>();
        //���String
        ts.add("zhangsan");
        ts.add("lisi");
        ts.add("wangwu");
        for (String s: ts
             ) {
            // ��������
            System.out.println(s);
            /*���
                lisi
                wangwu
                zhangsan
             */
        }
    }
/*
    �Ȱ������������������һ�����ٰ�����������
 */
    @Test
    public void test_treeSet2() {
        TreeSet<Vip> vips = new TreeSet<>();
        vips.add(new Vip("zhangsan",20));
        vips.add(new Vip("zangsan",20));
        vips.add(new Vip("lisi",18));
        for (Vip v: vips
             ) {
            System.out.println(v);
        }
    }

    /*
        TreeSet/TreeMap�洢�Զ�����ʵ������
        �ڶ��ַ�ʽ��ʵ�ֱȽ����ӿ�
        1.������дһ���Զ�����ıȽ����࣬ʵ��Comparator�ӿ�
        2.�������ϵ�ʱ��ͨ���вι��췽������Ƚ�����
    */
    @Test
    public void test_Comparator() {
        // �����Զ����༯�ϵ�ʱ��ͨ���вι��췽�������Զ�����ıȽ�����
        TreeSet<Animal> an = new TreeSet<>(new AnimalComparator());
        an.add(new Animal(100));
        an.add(new Animal(80));
        an.add(new Animal(79));
        for (Animal a:an) {
            System.out.println(a);
            /*�����
                Animal{age=79}
                Animal{age=80}
                Animal{age=100}
             */
        }
    }
    /*
        ʹ�������ڲ���ķ�ʽʵ��Comparator�ӿ�
        ����������дһ���Զ�����ıȽ����ࣩ
     */
    @Test
    public void test_Comparator2() {
        // ʹ�������ڲ���ķ�ʽʵ��Comparator�ӿ�
        TreeSet<Animal> an = new TreeSet<>(new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.age-o2.age;
            }
        });
        an.add(new Animal(100));
        an.add(new Animal(80));
        an.add(new Animal(79));
        for (Animal a:an) {
            System.out.println(a);
            /*�����
                Animal{age=79}
                Animal{age=80}
                Animal{age=100}
             */
        }
    }
}

class Vip implements Comparable<Vip>{
    String name;
    int age;

    @Override//��д����ȽϵĹ���
    public int compareTo(Vip v) {
        if (this.age == v.age) {
            // ������ͬ������������
            return this.name.compareTo(v.name);
        } else {
            return this.age - v.age;//���򣬷���ֵ������>0,=0,<0
            // return this.age - v.age;//����
        }
    }

    public Vip(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Vip{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Animal {
    int age;

    public Animal(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }
}

// ������дһ���Զ�����ıȽ���
// �Ƚ���ʵ��Comparator�ӿڡ���Comparable��Java.lang���µģ�Comparator��java.util���µģ�
class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        //ָ���ȽϹ���
        return o1.age-o2.age;
    }
}
