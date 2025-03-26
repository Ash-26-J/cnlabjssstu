import java.util.*;
import java.math.BigInteger;
class Main{
    BigInteger mod,pub,prv;
    void getkeys(int bitlen) {
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bitlen, r);
        BigInteger q = BigInteger.probablePrime(bitlen, r);
        mod = p.multiply(q);
        BigInteger pi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        pub = BigInteger.probablePrime(bitlen / 2, r);
        prv = pub.modInverse(pi);
    }
    BigInteger encrypt(BigInteger m){
        return m.modPow(pub,mod);
    }
    BigInteger decrypt(BigInteger c){
        return c.modPow(prv,mod);
    }
    public static void main(String[] args) {
        Main r = new Main();
        r.getkeys(1024);
        Scanner in = new Scanner(System.in);
        System.out.println("enter the message");
        BigInteger m = new BigInteger(in.next().getBytes());
        BigInteger c = r.encrypt(m);
        System.out.println("Encrypted message:" + c.longValue());
        BigInteger d = r.decrypt(c);
        System.out.println("decrypt the message:" + new String(d.toByteArray()));
    }
}
/*o/p
 enter the message
 ashishjoseph
Encrypted message:-1752810223501621926
decrypt the message:ashishjoseph
*/
