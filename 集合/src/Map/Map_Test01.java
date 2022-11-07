package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map_Test01 {
    /**
     * V put(K key,V value);��Map��������Ӽ�ֵ��
     */
    @Test
    public void test01() {
        // ����map����
        Map<Integer, String> map = new HashMap<>();
        //��map���������Ԫ��
        map.put(1, "zhangsan");
        map.put(2, "����");
        map.put(3, "����");
        //ͨ��key��ȡvalue
        String s = map.get(1);
        System.out.println(s);// �����zhangsan
    }

    /**
     * Set<Map.Entry<K,V>> entrySet();
     *
     * @return Set<Map.Entry < K, V>>
     * @Param
     */
    @Test
    public void test02() {
        // ��һ�ַ�ʽ����ȡ���е�key��ͨ������key,������value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "zhangsan");
        map.put(2, "����");
        map.put(3, "����");
        //����map����
        //��ȡ���е�key,���е�key��һ��Set����
        Set<Integer> keys = map.keySet();
        //1.����������
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        // 2.foreach����
        for (Integer key : keys) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("================================");
        // �ڶ��ֱ�����ʽ��Set<Map.Entry<K,V>> entrySet();
        // entrySet()�����ǰ�map����ֱ��ȫ��ת����set����
        // Set������Ԫ�ص������ǣ�Map.Entry
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        // ����set���ϣ�ÿһ��ȡ��һ��node
        // 1.������
        Iterator<Map.Entry<Integer, String>> it2 = set.iterator();
        while (it2.hasNext()) {
            Map.Entry<Integer, String> node = it2.next();
            Integer key = node.getKey();
            String value = node.getValue();
            System.out.println(key + "=" + value);
        }
        // 2.foreach
        for (Map.Entry<Integer, String> entry : set) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
        /*
        1=zhangsan
        2=����
        3=����
        1=zhangsan
        2=����
        3=����
        ================================
        1=zhangsan
        2=����
        3=����
        1--->zhangsan
        2--->����
        3--->����
         */
    }
}
