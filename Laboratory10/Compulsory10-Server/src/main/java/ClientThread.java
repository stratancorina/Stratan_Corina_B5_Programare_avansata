import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            String request = "continue";

            while (request.compareTo("stop") != 0) {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                request = in.readLine();

                // Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String answer = "Server received the request " + request;

                if (request.compareTo("stop") == 0)
                    answer = "Server stopped";

                out.println(answer);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}