import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class ClientThread extends Thread {
    private final Socket socket;
    private final SimpleServer simpleServer;
    private boolean runningClientThread = true;
    private boolean hasAccess = false;
    private String clientName;

    public ClientThread(Socket socket, SimpleServer simpleServer) {
        this.socket = socket;
        this.simpleServer = simpleServer;
    }

    public void run() {
        try {
            socket.setSoTimeout(30000);
        } catch (SocketException e) {
            try {
                socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        try {
            while (runningClientThread) {
                // Get the request from the input stream: client → server
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();

                // Send the response to the output stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String answer = "Server received the request " + request;

                if (request.compareTo("stop") == 0) {
                    simpleServer.setRunning(false);
                    runningClientThread = false;
                } else if (request.compareTo("exit") == 0) {
                    runningClientThread = false;
                } else if (request.compareTo("register") == 0) {
                    String name = in.readLine();
                    String password = in.readLine();

                    simpleServer.commands.register(new Person(name, password));

                    hasAccess = true;
                    clientName = name;
                } else if (request.compareTo("login") == 0) {
                    String name = in.readLine();
                    String password = in.readLine();

                    hasAccess = simpleServer.commands.login(name, password);

                    if (hasAccess) {
                        answer = "Welcome!";
                        clientName = name;
                    } else answer = "Login failed";

                } else if (request.compareTo("friend") == 0) {
                    String line = in.readLine();
                    String[] friends = line.split(",");

                    if (hasAccess) {
                        if (simpleServer.commands.friend(clientName, friends)) {
                            answer = "Done!";
                        } else answer = "Friends not found";
                    } else {
                        answer = "Permission denied";
                    }

                } else if (request.compareTo("send") == 0) {
                    String message = in.readLine();

                    if (hasAccess) {
                        simpleServer.commands.send(clientName, message);
                        answer = "Done!";
                    } else answer = "Permission denied";
                } else if (request.compareTo("read") == 0) {
                    if (hasAccess) {
                        answer = simpleServer.commands.read(clientName).toString();
                    } else answer = "Permission denied";
                }

                out.println(answer);
                out.flush();
            }
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
