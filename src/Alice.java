import java.math.BigInteger;

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
