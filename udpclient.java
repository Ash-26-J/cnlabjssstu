import java.util.*;
import java.io.*;
import java.net.*;

public class ownp2{
public static void main(String args[]) throws Exception{
DatagramSocket dgSocket = new DatagramSocket(5000);
DatagramPacket dgPacket ;
byte buffer[];
System.out.println("the message recived is \n");
while(true){
buffer = new byte[65555];
dgPacket = new DatagramPacket(buffer,buffer.length);
dgSocket.receive(dgPacket);
String receive = new String(buffer).trim();
System.out.println(receive);
if(receive.equalsIgnoreCase("exit")){
 dgSocket.close();
 break;
 }
 }
 }
 }
 /*
o/p
     the message recived is 

h
e
l
l
o
w
o
r
l
*/
