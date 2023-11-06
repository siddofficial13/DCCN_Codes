server side

  import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;
            while ((inputLine = input.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                output.println("Server: " + inputLine); // Echo back to the client
            }

            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


client side


  import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            Socket clientSocket = new Socket("localhost", 9999);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Connected to server. Type 'quit' to exit.");

            String userInputLine;
            while ((userInputLine = userInput.readLine()) != null) {
                if (userInputLine.equalsIgnoreCase("quit")) {
                    break;
                }
                output.println(userInputLine);

                String response = input.readLine();
                System.out.println("Server: " + response);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

  
