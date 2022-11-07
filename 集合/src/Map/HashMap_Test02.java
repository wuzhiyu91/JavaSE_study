package Map;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashMap_Test02 {
    /**
     * 1.向Map集合中村，以及从Map集合中取，都是先调用key的hashCode方法，然后在调用equals方法！
     * equals方法有可能调用，也有可能不调用
     * 以put（K,V）举例，什么时候equals不会调用？
     *      k.hashCode()方法返回哈希值，哈希值经过哈希算法转换成数组下标，数组下标位置上是null,equals不需要执行
     * 以get(k) 举例，什么时候equals不会调用？
     *      数组下标位置上是null,equals不需要执行
     * 2.如果一个类的equals方法重写了，那么hashCode（）方法必须重写.
     *      equals方法和hashCode方法同时重写后，equals方法返回true表示两个对象相同，
     *      是在同一个单向链表上比较，那么对于同一个单向链表上的节点来说，他们的哈希值都是相同的
     *      所以hashCode()方法的返回值也必定相同
     */
    @Test
    public void test01(){
        Student s1 = new Student("zhangsan");
        Student s2 = new Student("zhangsan");
        //重写equals方法之后,结果是true
        System.out.println(s1.equals(s2));//true(s1和s2表示相等)
        System.out.println("s1的hashcode:"+s1.hashCode());//399573350
        System.out.println("s2的hashcode:"+s2.hashCode());//463345942
        // s1.equals(s2)结果是true,表示s1和s2是相同的，那么往HashSet集合中存放的话
        //按说只能放进去1个（HashSet集合特点：无序不可重复）
        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        System.out.println(students.size());// 输出：2。这个结果按说应该是1，但是结果是2，显然不符合HashSet存储特点
        for (Student stu: students) {
            System.out.println(stu);
        }
    }

    @Test
    public void test02(){
        User u1 = new User("zhangsan");
        User u2 = new User("zhangsan");
        //重写equals方法之后,结果是true
        System.out.println(u1.equals(u2));//true(s1和s2表示相等)
        System.out.println("u1的hashcode:"+u1.hashCode());//-1432604525
        System.out.println("u2的hashcode:"+u2.hashCode());//-1432604525
        // s1.equals(s2)结果是true,表示s1和s2是相同的，那么往HashSet集合中存放的话
        //equals方法和hashCode方法同时重写后，只能放进去1个（HashSet集合特点：无序不可重复）
        Set<User> Users = new HashSet<>();
        Users.add(u1);
        Users.add(u2);
        System.out.println(Users.size());// 输出：1

    }
}
