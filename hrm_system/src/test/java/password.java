import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 18:51
 **/
public class password {
    public static void main(String[] args) {
        String s1 = new Md5Hash("123456", "13800000001", 3).toString();
        System.out.println(s1);
    }
}
