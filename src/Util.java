import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.Random;

public class Util {
    private BigInteger prim;
    public BigInteger g;

    public Util() {
        Random rnd = new Random(new Date().getTime());
        this.prim=BigInteger.probablePrime(8, rnd);
        this.g=this.prim.add(BigInteger.valueOf(1));
    }

    public BigInteger getPrim() {
        return prim;
    }




    private static String RSA="RSA";

    public static KeyPair generateRSAKeyPair(){
        return generateRSAKeyPair(1024);
    }



    /**
     * 随机生成密钥对
     * @param i
     * @return
     */
    private static KeyPair generateRSAKeyPair(int i) {
        try {
            KeyPairGenerator kpg=KeyPairGenerator.getInstance(RSA);
            kpg.initialize(i);
            return kpg.genKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    public static PublicKey getPublicKey(byte[] keyBytes){
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(keyBytes);

    }

     */


}
