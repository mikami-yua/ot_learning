import java.math.BigInteger;

public class Bob {
    Util u;
    int i=0;
    int key=987654;
    public BigInteger g;
    private BigInteger p;




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
