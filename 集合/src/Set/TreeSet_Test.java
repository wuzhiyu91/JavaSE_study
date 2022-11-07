package Set;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * TreeSet集合存储元素特点：
 *  1.无序不可重复的，但是存储的元素可以自动按照大小顺序排序，称为：可排序集合
 *  2.无序：指的是存进去的顺序和取出来的顺序不同，并且没有下标
 */

public class TreeSet_Test {
    @Test // 无序不可重复的，但是存储的元素可以自动按照大小顺序排序，称为：可排序集合
    public void test01() {
        // 创建集合对象
        Set<String> strs = new TreeSet<>();
        // 添加元素
        strs.add("A");
        strs.add("M");
        strs.add("C");
        strs.add("E");
        strs.add("G");
        // 遍历
        for (String a: strs
             ) {
            System.out.println(a);
        }
        /*输出：
        *   A
            C
            E
            G
            M
        * */
        // TreeSet可以进行排序
    }
}
