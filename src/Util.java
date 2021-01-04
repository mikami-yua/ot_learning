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


    public static String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(i != chars.length - 1)
            {
                sbu.append((int)chars[i]).append(",");
            }
            else {
                sbu.append((int)chars[i]);
            }
        }
        return sbu.toString();
    }

    public static String asciiToString(String value)
    {
        StringBuffer sbu = new StringBuffer();
        String[] chars = value.split(",");
        for (int i = 0; i < chars.length; i++) {
            sbu.append((char) Integer.parseInt(chars[i]));
        }
        return sbu.toString();
    }

}
