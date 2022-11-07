package Map;

import Set.TreeSet_Test;
import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/*
    1.TreeSet集合底层实际上一个TreeMap
    2.TreeMap集合底层是一个二叉树
    3.放到TreeSet集合中的元素，等同于放到TreeMap集合的key部分了
    4.TreeSet集合中的元素：无序不可重复，但是可以按照元素的大小顺序自动排序，成为可排序集合

 */
public class TreeMap_Test01 {
    @Test
    public void test_treeSet() {
        // 创建一个TreeSet集合
        TreeSet<String> ts = new TreeSet<>();
        //添加String
        ts.add("zhangsan");
        ts.add("lisi");
        ts.add("wangwu");
        for (String s: ts
             ) {
            // 升序排序
            System.out.println(s);
            /*输出
                lisi
                wangwu
                zhangsan
             */
        }
    }
/*
    先按照年龄升序，如果年龄一样，再按照姓名升序
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
        TreeSet/TreeMap存储自定义类实现排序
        第二种方式：实现比较器接口
        1.单独编写一个自定义类的比较器类，实现Comparator接口
        2.创建集合的时候，通过有参构造方法传入比较器类
    */
    @Test
    public void test_Comparator() {
        // 创建自定义类集合的时候，通过有参构造方法传入自定义类的比较器类
        TreeSet<Animal> an = new TreeSet<>(new AnimalComparator());
        an.add(new Animal(100));
        an.add(new Animal(80));
        an.add(new Animal(79));
        for (Animal a:an) {
            System.out.println(a);
            /*输出：
                Animal{age=79}
                Animal{age=80}
                Animal{age=100}
             */
        }
    }
    /*
        使用匿名内部类的方式实现Comparator接口
        （不用另外写一个自定义类的比较器类）
     */
    @Test
    public void test_Comparator2() {
        // 使用匿名内部类的方式实现Comparator接口
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
            /*输出：
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

    @Override//重写排序比较的规则
    public int compareTo(Vip v) {
        if (this.age == v.age) {
            // 年龄相同按照名字排序
            return this.name.compareTo(v.name);
        } else {
            return this.age - v.age;//升序，返回值可能是>0,=0,<0
            // return this.age - v.age;//降序
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

// 单独编写一个自定义类的比较器
// 比较器实现Comparator接口。（Comparable是Java.lang包下的，Comparator是java.util包下的）
class AnimalComparator implements Comparator<Animal> {

    @Override
    public int compare(Animal o1, Animal o2) {
        //指定比较规则
        return o1.age-o2.age;
    }
}
