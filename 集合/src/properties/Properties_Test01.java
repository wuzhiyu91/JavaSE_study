package properties;

import org.junit.Test;

import java.util.Properties;
/*
    Properties被成为属性类对象，是一个Map集合，继承Hashtable；
    Properties的key和value只允许是String类型
 */
public class Properties_Test01 {
    @Test
    public void test01() {
        // 创建一个Properties对象
        Properties p = new Properties();
        // 需要掌握Properties的两个方法，一个存，一个取
        p.setProperty("username", "root");
        p.setProperty("password", "123");
        //通过key获取value
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        System.out.println(username);
        System.out.println(password);
    }
}
