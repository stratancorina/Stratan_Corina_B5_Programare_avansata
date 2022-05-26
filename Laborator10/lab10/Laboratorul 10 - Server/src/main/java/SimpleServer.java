import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class SimpleServer {
    // Define the port on which the server is listening
    public static final int PORT = 8100;
    private boolean running = true;

    public final Commands commands = new Commands();

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            serverSocket.setSoTimeout(30000);

            while (running) {
                Socket socket = null;

                try {
                    socket = serverSocket.accept();
                } catch (SocketTimeoutException e) {
//                    System.out.println("I timed out!");
                }

                // Execute the client's request in a new thread
                if (socket != null) {
                    new ClientThread(socket, this).start();
                }
            }
        } catch (IOException e) {
            System.err.println("Error... " + e);
        } finally {
            serverSocket.close();
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public static void main(String[] args) throws IOException {
        SimpleServer server = new SimpleServer();
    }
}
