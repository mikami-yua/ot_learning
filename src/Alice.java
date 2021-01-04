import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * alice是发送方
 */
public class Alice {
    Util u;
    private int v0=11111111;
    private int v1=22222222;
    private int sKey=123456;
    private int roKey=123123;
    private int r1Key=456456;
    public BigInteger g;
    public BigInteger gs;
    public BigInteger Li;
    public BigInteger[] c0,c1;

    //
    //以下使用RSA的方式构建

    private BigInteger p;
    private BigInteger q;
    public BigInteger n;
    private BigInteger lcm;
    public BigInteger e;//n与n+1互质，证明见百度
    private BigInteger d;
    public BigInteger r0= BigInteger.valueOf(0000000);//随机消息1
    public BigInteger r1= BigInteger.valueOf(1111111);//随机消息2
    public BigInteger v;
    private BigInteger m0= BigInteger.valueOf(99999999);
    private BigInteger m1= BigInteger.valueOf(888888888);
    /*
    公钥e的取值问题  https://blog.csdn.net/jiftlixu/article/details/19029863
    综上所述，选用e=3作为RSA的公钥指数，只要使用正确的填充方案，目前仍然是安全的。

    关于e=65537的说明

    这是一个推荐使用的公钥指数，我认为选这个值的目的只是一个介于低指数攻击和运算效率之间的一个折中考虑，
    即以防万一"e=3"被攻破而侥幸"e=65537"可能还是安全的。另外，NIST SP800-78 Rev 1 (2007) 也曾强调“不允许使用比65537更低的公钥指数e”，
    但对于该限制却没有给出任何理由。而PKCS#1却从未有过类似的建议。

     */




    /**
     * 完成RSA based的第一步，生成两个随机数，并且 发送公钥
     * @return
     */
    public BigInteger[] sendRSAMsg(){
        Random rnd = new Random(new Date().getTime());
        this.p= BigInteger.probablePrime(16,rnd);
        this.q= BigInteger.probablePrime(16,rnd);
        this.n=q.multiply(p);
        this.lcm=p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)));
        this.e=lcm.subtract(BigInteger.valueOf(1));//n与n+1互质，证明见百度
        this.d=e.modInverse(lcm);

        this.r0= BigInteger.valueOf(rnd.nextInt(Integer.MAX_VALUE));
        this.r1= BigInteger.valueOf(rnd.nextInt(Integer.MAX_VALUE));

        BigInteger[] ret=new BigInteger[4];
        ret[0]=n;
        ret[1]=e;
        ret[2]=r0;
        ret[3]=r1;

        return ret;
    }

    /**
     * alice把收到v后，计算的ki发送给bob
     * @return
     */
    public BigInteger[] sendMi(){
        BigInteger k0=v.subtract(r0).modPow(d,n);
        BigInteger k1=v.subtract(r1).modPow(d,n);

        BigInteger[] Mi=new BigInteger[2];
        Mi[0]=this.m0.add(k0);
        Mi[1]=this.m1.add(k1);
        return Mi;
    }









    //

    /**
     * 计算g的s次方
     *
     */
    public BigInteger sendGs(){
        this.gs=this.g.pow(this.sKey);
        return this.gs;
    }

    public void generateCi(){
        this.c0=new BigInteger[2];
        this.c1=new BigInteger[2];
        c0[0]=this.g.pow(this.roKey);
        c0[1]=this.Li.pow(this.roKey);
        c0[1]=c0[1].xor(BigInteger.valueOf(v0));

        c1[0]=this.g.pow(this.r1Key);
           c1[1]=this.gs.divide(Li);
        c1[1]=c1[1].pow(this.r1Key);
        c1[1]=c1[1].xor(BigInteger.valueOf(v1));
    }

    public BigInteger[][] sendCi(){
        BigInteger[][] ret=new BigInteger[2][2];
        for(int i=0;i<2;i++){
            ret[0][i]=this.c0[i];
        }
        for(int i=0;i<2;i++){
            ret[1][i]=this.c1[i];
        }

        return ret;
    }

}
