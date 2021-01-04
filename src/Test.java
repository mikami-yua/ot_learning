import java.math.BigInteger;
import java.util.Date;
import java.util.Random;
/*
http://blog.sina.com.cn/s/blog_72529adc0102ww2z.html
RSA使用pq实现的教程
 */


public class Test {
    public static void main(String[] args) {
        Random rnd = new Random(new Date().getTime());
        BigInteger p= BigInteger.probablePrime(512, rnd);
        BigInteger q= BigInteger.probablePrime(512, rnd);
        BigInteger n=q.multiply(p);
        BigInteger lcm=p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        //BigInteger e=lcm.subtract(BigInteger.valueOf(1));//n与n+1互质，证明见百度
        int e=3;
        //BigInteger d=BigInteger.valueOf(e).modInverse(lcm);

//        BigInteger ret=e.multiply(d).mod(lcm);
//        System.out.println(ret);
//        System.out.println(d);
//        System.out.println(Integer.valueOf(String.valueOf(d)));



        String str = "测试转换程序是否好用";
        String asciiResult = Util.stringToAscii(str);
        System.out.println(asciiResult);
        String stringResult = Util.asciiToString(asciiResult);
        System.out.println(stringResult);
    }

}
