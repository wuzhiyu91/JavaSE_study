package properties;

import org.junit.Test;

import java.util.Properties;
/*
    Properties����Ϊ�����������һ��Map���ϣ��̳�Hashtable��
    Properties��key��valueֻ������String����
 */
public class Properties_Test01 {
    @Test
    public void test01() {
        // ����һ��Properties����
        Properties p = new Properties();
        // ��Ҫ����Properties������������һ���棬һ��ȡ
        p.setProperty("username", "root");
        p.setProperty("password", "123");
        //ͨ��key��ȡvalue
        String username = p.getProperty("username");
        String password = p.getProperty("password");
        System.out.println(username);
        System.out.println(password);
    }
}
