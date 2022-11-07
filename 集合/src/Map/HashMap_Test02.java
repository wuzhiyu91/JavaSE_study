package Map;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class HashMap_Test02 {
    /**
     * 1.��Map�����д壬�Լ���Map������ȡ�������ȵ���key��hashCode������Ȼ���ڵ���equals������
     * equals�����п��ܵ��ã�Ҳ�п��ܲ�����
     * ��put��K,V��������ʲôʱ��equals������ã�
     *      k.hashCode()�������ع�ϣֵ����ϣֵ������ϣ�㷨ת���������±꣬�����±�λ������null,equals����Ҫִ��
     * ��get(k) ������ʲôʱ��equals������ã�
     *      �����±�λ������null,equals����Ҫִ��
     * 2.���һ�����equals������д�ˣ���ôhashCode��������������д.
     *      equals������hashCode����ͬʱ��д��equals��������true��ʾ����������ͬ��
     *      ����ͬһ�����������ϱȽϣ���ô����ͬһ�����������ϵĽڵ���˵�����ǵĹ�ϣֵ������ͬ��
     *      ����hashCode()�����ķ���ֵҲ�ض���ͬ
     */
    @Test
    public void test01(){
        Student s1 = new Student("zhangsan");
        Student s2 = new Student("zhangsan");
        //��дequals����֮��,�����true
        System.out.println(s1.equals(s2));//true(s1��s2��ʾ���)
        System.out.println("s1��hashcode:"+s1.hashCode());//399573350
        System.out.println("s2��hashcode:"+s2.hashCode());//463345942
        // s1.equals(s2)�����true,��ʾs1��s2����ͬ�ģ���ô��HashSet�����д�ŵĻ�
        //��˵ֻ�ܷŽ�ȥ1����HashSet�����ص㣺���򲻿��ظ���
        Set<Student> students = new HashSet<>();
        students.add(s1);
        students.add(s2);
        System.out.println(students.size());// �����2����������˵Ӧ����1�����ǽ����2����Ȼ������HashSet�洢�ص�
        for (Student stu: students) {
            System.out.println(stu);
        }
    }

    @Test
    public void test02(){
        User u1 = new User("zhangsan");
        User u2 = new User("zhangsan");
        //��дequals����֮��,�����true
        System.out.println(u1.equals(u2));//true(s1��s2��ʾ���)
        System.out.println("u1��hashcode:"+u1.hashCode());//-1432604525
        System.out.println("u2��hashcode:"+u2.hashCode());//-1432604525
        // s1.equals(s2)�����true,��ʾs1��s2����ͬ�ģ���ô��HashSet�����д�ŵĻ�
        //equals������hashCode����ͬʱ��д��ֻ�ܷŽ�ȥ1����HashSet�����ص㣺���򲻿��ظ���
        Set<User> Users = new HashSet<>();
        Users.add(u1);
        Users.add(u2);
        System.out.println(Users.size());// �����1

    }
}
