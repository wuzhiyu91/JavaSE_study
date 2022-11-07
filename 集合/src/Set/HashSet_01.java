package Set;

import org.junit.Test;

import java.util.HashSet;

/**
 * HashSet集合
 *  1.无序不可重复
 */
public class HashSet_01 {
    @Test // 无序不可重复
    public void test01() {
        //HashSet集合特点：无序不可重复
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
        /*输出：
            hello1
            hello4
            hello2
            hello3
         */
        // 结果看出：存入顺序和取出顺序不同->无序不可重复
    }
}
