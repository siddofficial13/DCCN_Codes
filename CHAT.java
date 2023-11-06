client side

  import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            Thread readServer = new Thread(() -> {
                try {
                    while (true) {
                        String serverInput = input.readLine();
                        if (serverInput == null) {
                            break;
                        }
                        System.out.println("Server: " + serverInput);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readServer.start();

            String clientInput;
            while (true) {
                clientInput = consoleInput.readLine();
                output.println(clientInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


server side

  import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));

            Thread readClient = new Thread(() -> {
                try {
                    while (true) {
                        String clientInput = input.readLine();
                        if (clientInput == null) {
                            break;
                        }
                        System.out.println("Client: " + clientInput);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            readClient.start();

            String serverInput;
            while (true) {
                serverInput = consoleInput.readLine();
                output.println(serverInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
