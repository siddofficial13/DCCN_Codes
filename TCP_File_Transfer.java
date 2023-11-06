server side

import java.io.*;
import java.net.*;

public class FileServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Server started. Waiting for a client...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
            String fileName = dis.readUTF();
            System.out.println("Receiving file: " + fileName);

            // Create a file output stream to save the file
            FileOutputStream fos = new FileOutputStream(fileName);
            byte[] buffer = new byte[4096];

            int filesize = dis.readInt();
            int read = 0;
            int totalRead = 0;
            int remaining = filesize;

            while ((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {
                totalRead += read;
                remaining -= read;
                fos.write(buffer, 0, read);
            }

            System.out.println("File received successfully!");
            fos.close();
            dis.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


client side

import java.io.*;
import java.net.*;

public class FileClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // Server IP address
        int serverPort = 5555; // Server port
        String fileName = "test.txt"; // Replace with the name of the file to be sent

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send the file name to the server
            dos.writeUTF(fileName);

            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);

            dos.writeInt((int) file.length());

            byte[] buffer = new byte[4096];
            int read;
            while ((read = fis.read(buffer)) > 0) {
                dos.write(buffer, 0, read);
            }

            System.out.println("File sent successfully!");
            fis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

