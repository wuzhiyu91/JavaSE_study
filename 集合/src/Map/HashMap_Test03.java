package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMap_Test03 {
    /** HashMap �� HashTable ������
        1.HashMap���ϵ�key��value����洢null
        2.Hashtable���ϵ�key��value���������ǿ�
     */
    @Test
    public void test01() {
        Map map1 = new HashMap();
        Map map2 = new Hashtable();
        // HashMap��������key��value�洢null
        map1.put(null, null);
        System.out.println(map1.size());
        System.out.println(map1.get(null));//null

        map2.put(1, null);
        System.out.println(map2.size());
    }
}
