import java.util.*;
import java.io.*;
import java.net.*;

public class owns{
public static void main(String args[]) throws Exception{
Scanner in = new Scanner(System.in);
ServerSocket sersoc = new ServerSocket(4000);
System.out.println("connection established\n");
Socket sock = sersoc.accept();
System.out.println("waiting to recive file name \n");
InputStream istream = sock.getInputStream();
String fname = in.nextLine();
OutputStream ostream = sock.getOutputStream();
PrintWriter pwrite = new PrintWriter(ostream,true);
try{
    in = new Scanner(new File(fname));
    while(in.hasNextLine()){
    pwrite.println(in.nextLine());
    }
    }catch(Exception e){
     pwrite.println("file not found");
    }finally{
    System.out.println("connection ended");
    }
    }
    }
/*    
o/p
connection established

waiting to recive file name 

hello1.txt
connection ended

    */
