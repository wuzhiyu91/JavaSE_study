package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_Test01 {
    /**
     * ����HashMap����key���ֵ�Ԫ�أ��Լ�����HashSet�����е�Ԫ�أ���Ҫͬʱ��дequals��hashcode����
     */

    @Test
    public void test01() {
        //����hashMap����key���ֵ�Ԫ���ص�
        // Integer��key,hashCode��equals����д��
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"zhangsan ");
        map.put(2,"lisi ");
        map.put(7,"wangwu ");
        map.put(6,"zhaoliu");
        map.put(2,"hahaha");//key�ظ���ʱ��value���Զ�����
        System.out.println(map.size());//�����4

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry: set) {
            // ��֤�����hashMap����key����Ԫ�ز����ظ�
            System.out.println(entry.getKey()+"="+entry.getValue());
            /*
                1=zhangsan
                2=hahaha
                6=zhaoliu
                7=wangwu
            */
        }
    }
}
