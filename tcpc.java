import java.net.*;
import java.io.*;

public class TCPc {
    public static void main(String[] args) throws Exception {
        // Connect to server on localhost (127.0.0.1) at port 4000
        Socket sock = new Socket("127.0.0.1", 9000);  // Correct IP Address
        System.out.println("Connected to the server.");

        // Read the filename from user input
        System.out.println("Enter the filename:");
        BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyRead.readLine();

        // Send the filename to the server
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);  // Send filename to server

        // Receive the file content from the server
        InputStream istream = sock.getInputStream();
        BufferedReader socketRead = new BufferedReader(new InputStreamReader(istream));
        String str;

        // Print the received data (file content)
        while ((str = socketRead.readLine()) != null) {
            System.out.println(str);
        }

        // Close all resources
        pwrite.close();
        socketRead.close();
        keyRead.close();
        sock.close();
    }
}
