package Set;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet���ϴ洢Ԫ���ص㣺
 *  1.���򲻿��ظ��ģ����Ǵ洢��Ԫ�ؿ����Զ����մ�С˳�����򣬳�Ϊ�������򼯺�
 *  2.����ָ���Ǵ��ȥ��˳���ȡ������˳��ͬ������û���±�
 */

public class TreeSet_Test {
    @Test // ���򲻿��ظ��ģ����Ǵ洢��Ԫ�ؿ����Զ����մ�С˳�����򣬳�Ϊ�������򼯺�
    public void test01() {
        // �������϶���
        Set<String> strs = new TreeSet<>();
        // ���Ԫ��
        strs.add("A");
        strs.add("M");
        strs.add("C");
        strs.add("E");
        strs.add("G");
        // ����
        for (String a: strs
             ) {
            System.out.println(a);
        }
        /*�����
        *   A
            C
            E
            G
            M
        * */
        // TreeSet���Խ�������
    }
}
