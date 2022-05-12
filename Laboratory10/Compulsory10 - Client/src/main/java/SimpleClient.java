import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
    public static void main(String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (Socket socket = new Socket(serverAddress, PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String request = "continue";

            while (request.compareTo("stop") != 0) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("Your request: ");

                if (request.compareTo("exit") == 0) {
                    request = "stop";
                }

                try {
                    request = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Send a request to the server
                out.println(request);

                // Wait the response from the server ("Hello World!")
                String response = in.readLine();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}