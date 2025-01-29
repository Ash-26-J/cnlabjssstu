import java.util.Scanner;
public class CRC{
 private static final int POLYNOMIAL=0x1021;
 private static final int INITIAL_CRC=0xFFFF;
public static int computecrc(byte[] data){
 int crc=INITIAL_CRC;
 for(byte b:data){
  crc^=(b<<8);
 for(int i=0;i<8;i++){
  if((crc & 0x8000)!=0){
   crc=(crc<<1)^POLYNOMIAL;
  }
  else{
   crc=crc<<1;
  }
  crc&=0xFFFF;
 }
 }
 return crc;
}
public static boolean verifycrc(byte[] data, int receivedcrc){
 int computedcrc=computecrc(data);
 return computedcrc==receivedcrc;
}
public static void main(String[] args){
 Scanner sc=new Scanner(System.in);
 System.out.println("Enter data to transmit:");
 String input=sc.nextLine();
 byte[] data=input.getBytes();
 int crc=computecrc(data);
 System.out.printf("Computed crc:0x%04X\n",crc);
 System.out.println("\nSimulating data transmission\n");
 System.out.println("Enter the recieved data:");
 String receivedinput=sc.nextLine();
 byte[] receivedData=receivedinput.getBytes();
 System.out.printf("Enter the recieved crc in hexadecimal(computed crc is 0x%04X: ",crc);
 int receivedcrc=Integer.parseInt(sc.nextLine(),16);
 if(verifycrc(receivedData,receivedcrc)){
  System.out.println("No erors detected. Data is valid");
 }else{
  System.out.println("Errors detected, data is invalid");
 }
 sc.close();
 }
}  
/*o/p
 enter the data buit :100110
 enter tbe data:1001100010101011110110
 enter the data that was recived:1001100010101011110110
 data is correct
  */
