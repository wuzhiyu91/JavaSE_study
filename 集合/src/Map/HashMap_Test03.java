package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMap_Test03 {
    /** HashMap 和 HashTable 的区别
        1.HashMap集合的key和value允许存储null
        2.Hashtable集合的key和value都不允许是空
     */
    @Test
    public void test01() {
        Map map1 = new HashMap();
        Map map2 = new Hashtable();
        // HashMap集合允许key和value存储null
        map1.put(null, null);
        System.out.println(map1.size());
        System.out.println(map1.get(null));//null

        map2.put(1, null);
        System.out.println(map2.size());
    }
}
