import java.math.BigInteger;

public class Bob {
    Util u;
    int i=0;
    int key=987654;
    public BigInteger g;
    private BigInteger p;

    //
    //RSA的OT
    private BigInteger k= BigInteger.valueOf(987654);
    public BigInteger e;
    public BigInteger n;
    public BigInteger aliceRet[];
    public BigInteger r;//待选择的随机消息r
    public BigInteger[] mi;

    public BigInteger sendV(){
        this.n=aliceRet[0];
        this.e=aliceRet[1];
        if (i==0){
            this.r=aliceRet[2];
        }else {
            this.r=aliceRet[3];
        }
        //BigInteger temp=k.pow(this.e);
        /*
        模运算的数学法则
            (a + b) % p = (a % p + b % p) % p （1）
            (a - b) % p = (a % p - b % p ) % p （2）
            (a * b) % p = (a % p * b % p) % p （3）
            a ^ b % p = ((a % p)^b) % p （4）
         */
        BigInteger temp1=k.modPow(e,n);
        BigInteger temp2=r.mod(n);
        BigInteger v=temp1.add(temp2).mod(n);
        return v;

    }

    public void deCodeMsg(){
        System.out.println(mi[0].subtract(k));
        System.out.println(mi[1].subtract(k));
    }























    //


    public BigInteger gs;

    public BigInteger[][] Ci;

    public BigInteger sendLi(){
        BigInteger ret;
        this.p =u.getPrim() ;
        if (this.i==0){
            ret=this.g.pow(this.key);
        }else {
            ret=this.g.pow(this.key).modInverse(this.p);
            System.out.println(ret);
            ret=ret.multiply(this.gs);
        }
        return ret;
    }

    public void deEncrytion(){
        BigInteger ret1;
        BigInteger ret2;

        ret1=Ci[0][0].pow(this.key).xor(Ci[0][1]);
        ret2=Ci[1][0].pow(this.key).xor(Ci[1][1]);

        System.out.println(ret1);
        System.out.println(ret2);
    }

}
