import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @description:
 * @author: Mr.DAMO
 * @create: 2020-03-21 18:51
 **/
public class password {
    public static void main(String[] args) {
        String s1 = new Md5Hash("123456", "4124124124", 3).toString();
        String s2 = new Md5Hash("123456", "123123123", 3).toString();
        String s3 = new Md5Hash("123456", "1231231123", 3).toString();
        String s4 = new Md5Hash("123456", "345345", 3).toString();
        String s5 = new Md5Hash("123456", "1234567", 3).toString();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }
}
