import java.util.*;
import java.net.*;
import java.io.*;

public class ownp1{
public static void main(String args[]) throws Exception{
Scanner in = new Scanner (System.in);
DatagramSocket dgSocket = new DatagramSocket();
InetAddress address = InetAddress.getByName("127.0.0.1");
DatagramPacket dgPacket;
String message;
byte buffer[];
System.out.println("enter the message \n");
while(true){
message = in.nextLine();
buffer = message.getBytes();
dgPacket = new DatagramPacket(buffer,buffer.length,address,5000);
dgSocket.send(dgPacket);

if(message.equalsIgnoreCase("exisit"))
{
  dgSocket.close();
   break;
}
}
}
} 
/* o/p
   enter the message 

h
e
l
l
o
w
o
r
l
d
*/ 
