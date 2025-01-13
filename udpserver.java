import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = null;
        try {
            serverSocket = new DatagramSocket(9996);
            System.out.println("Server is ready for the client");
            byte[] receivedData = new byte[1024];
            byte[] sendData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
                serverSocket.receive(receivePacket); 

                String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength()); 
                System.out.println("Received: " + sentence);

                InetAddress IPAddress = receivePacket.getAddress(); 
                int port = receivePacket.getPort(); 

                String capitalizedSentence = sentence.toUpperCase(); 
                sendData = capitalizedSentence.getBytes(); 
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                serverSocket.send(sendPacket); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        }
    }
}
