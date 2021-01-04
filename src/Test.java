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
        BigInteger p= BigInteger.probablePrime(8, rnd);
        BigInteger q= BigInteger.probablePrime(8, rnd);
        BigInteger n=q.multiply(q);
        BigInteger lcm=p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        BigInteger e=lcm.subtract(BigInteger.valueOf(1));//n与n+1互质，证明见百度
        BigInteger d=e.modInverse(lcm);

//        BigInteger ret=e.multiply(d).mod(lcm);
//        System.out.println(ret);

    }

}
