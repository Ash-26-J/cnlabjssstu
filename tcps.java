import java.net.*;
import java.io.*;

public class TCPs {
    public static void main(String[] args) throws Exception {
        // Create a server socket listening on port 4000
        ServerSocket sersock = new ServerSocket(9000);
        System.out.println("Server ready for connection");

        // Wait for a client to connect
        Socket sock = sersock.accept();
        System.out.println("Connection is successful and waiting for chatting");

        // Input stream to receive data from the client
        InputStream istream = sock.getInputStream();
        BufferedReader clientRead = new BufferedReader(new InputStreamReader(istream));

        // Read the filename sent by the client
        String fname = clientRead.readLine();  // Read filename from client
        File file = new File(fname);

        // Check if the file exists
        if (file.exists() && !file.isDirectory()) {
            // File exists, read its content and send to the client
            BufferedReader fileRead = new BufferedReader(new FileReader(fname));
            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);

            String str;
            // Read and send each line of the file
            while ((str = fileRead.readLine()) != null) {
                pwrite.println(str);
            }

            // Close resources
            fileRead.close();
            pwrite.close();
        } else {
            // If file does not exist, send error message
            OutputStream ostream = sock.getOutputStream();
            PrintWriter pwrite = new PrintWriter(ostream, true);
            pwrite.println("Error: File not found.");
        }

        // Close the socket and server socket
        sock.close();
        sersock.close();
        clientRead.close();
    }
}
