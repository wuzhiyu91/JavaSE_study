package Set;

import org.junit.Test;

import java.util.HashSet;

/**
 * HashSet����
 *  1.���򲻿��ظ�
 */
public class HashSet_01 {
    @Test // ���򲻿��ظ�
    public void test01() {
        //HashSet�����ص㣺���򲻿��ظ�
        HashSet<String> strs = new HashSet<>();
        strs.add("hello1");
        strs.add("hello2");
        strs.add("hello3");
        strs.add("hello4");
        strs.add("hello4");
        strs.add("hello4");
        strs.add("hello4");
        for (String s : strs
             ) {
            System.out.println(s);
        }
        /*�����
            hello1
            hello4
            hello2
            hello3
         */
        // �������������˳���ȡ��˳��ͬ->���򲻿��ظ�
    }
}
