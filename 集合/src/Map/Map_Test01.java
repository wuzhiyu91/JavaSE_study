package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map_Test01 {
    /**
     * V put(K key,V value);向Map集合中添加键值对
     */
    @Test
    public void test01() {
        // 创建map集合
        Map<Integer, String> map = new HashMap<>();
        //向map集合中添加元素
        map.put(1, "zhangsan");
        map.put(2, "李四");
        map.put(3, "王五");
        //通过key获取value
        String s = map.get(1);
        System.out.println(s);// 输出：zhangsan
    }

    /**
     * Set<Map.Entry<K,V>> entrySet();
     *
     * @return Set<Map.Entry < K, V>>
     * @Param
     */
    @Test
    public void test02() {
        // 第一种方式：获取所有的key，通过遍历key,来遍历value
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "zhangsan");
        map.put(2, "李四");
        map.put(3, "王五");
        //遍历map集合
        //获取所有的key,所有的key是一个Set集合
        Set<Integer> keys = map.keySet();
        //1.迭代器迭代
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + "=" + value);
        }
        // 2.foreach迭代
        for (Integer key : keys) {
            System.out.println(key + "=" + map.get(key));
        }
        System.out.println("================================");
        // 第二种遍历方式：Set<Map.Entry<K,V>> entrySet();
        // entrySet()方法是把map集合直接全部转换成set集合
        // Set集合中元素的类型是：Map.Entry
        Set<Map.Entry<Integer, String>> set = map.entrySet();
        // 遍历set集合，每一次取出一个node
        // 1.迭代器
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
        2=李四
        3=王五
        1=zhangsan
        2=李四
        3=王五
        ================================
        1=zhangsan
        2=李四
        3=王五
        1--->zhangsan
        2--->李四
        3--->王五
         */
    }
}
