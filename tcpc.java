import java.util.*;
import java.io.*;
import java.net.*;

public class ownc{
public static void main(String args[]) throws Exception{
Scanner in  = new Scanner(System.in);
Socket sock = new Socket("127.0.0.1",4000);
System.out.println("enter the file name");
String fname = in.next();
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream,true);
InputStream istream = sock.getInputStream();
pwrite.println(fname);
in = new Scanner(new File(fname));
while(in.hasNextLine()){
System.out.println(in.nextLine());
}
}
}
/* o/p
   enter the file name
hello1.txt
emdede,,elf,relf,rlf,r,fr,f,rpf;lr
*/
