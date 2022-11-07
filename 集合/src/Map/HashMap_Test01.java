package Map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMap_Test01 {
    /**
     * 放在HashMap集合key部分的元素，以及放在HashSet集合中的元素，需要同时重写equals和hashcode方法
     */

    @Test
    public void test01() {
        //测试hashMap集合key部分的元素特点
        // Integer是key,hashCode和equals都重写了
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"zhangsan ");
        map.put(2,"lisi ");
        map.put(7,"wangwu ");
        map.put(6,"zhaoliu");
        map.put(2,"hahaha");//key重复的时候value会自动覆盖
        System.out.println(map.size());//输出：4

        Set<Map.Entry<Integer, String>> set = map.entrySet();
        for (Map.Entry<Integer, String> entry: set) {
            // 验证结果：hashMap集合key部分元素不可重复
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
