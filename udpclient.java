import java.io.*;
import java.net.*;
public class UDPClient {
    public static void main(String args[]) throws Exception {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost"); 
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.print("Enter message: ");
        String message = inFromUser.readLine();
        sendData = message.getBytes();  
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9996);
        clientSocket.send(sendPacket); 
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket); 
        String modifiedSentence = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
        System.out.println("Server: " + modifiedSentence); // Display the response from the server
        clientSocket.close();
    }
}
