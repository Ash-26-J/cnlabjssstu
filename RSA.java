import java.util.Scanner;;
import java.math.BigInteger;
import java.security.SecureRandom;
public class RSA{
 private BigInteger p,q,n,phi,e,d;
 private SecureRandom random;
public RSA(int bitlength){
 random=new SecureRandom();
 p=BigInteger.probablePrime(bitlength,random);
 q=BigInteger.probablePrime(bitlength,random);
 n=p.multiply(q);
 phi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
 e=BigInteger.probablePrime(bitlength/2,random);
 while(!phi.gcd(e).equals(BigInteger.ONE)||e.compareTo(phi)>=0)
 {
  e=BigInteger.probablePrime(bitlength/2,random);
 }
 d=e.modInverse(phi);
}
public BigInteger encrypt(BigInteger message){
 return message.modPow(e,n);
}
public BigInteger decrypt(BigInteger ciphertext){
 return ciphertext.modPow(d,n);
}
public BigInteger getPublicKey(){
 return e;
}
public BigInteger getMOdulus(){
 return n;
}
public static void main(String[] args){
 int bitlength=512;
 RSA rsa=new RSA(bitlength);
 System.out.println("Public key(e,n):( " +rsa.e+" , "+rsa.n+" )");
 System.out.println("Private key(d,n):( " +rsa.d+" , "+rsa.n+" )");
 Scanner in=new Scanner(System.in);
 System.out.println("Enter a message:");
 String plaintext=in.nextLine();
 BigInteger msg=new BigInteger(plaintext.getBytes());
 BigInteger ciphertext=rsa.encrypt(msg);
 System.out.println("Encrypted msg: "+ciphertext);
 BigInteger decrypttext=rsa.decrypt(ciphertext);
 String decrypted=new String(decrypttext.toByteArray());
 System.out.println("Decrypted message:"+decrypted);
}
} 
