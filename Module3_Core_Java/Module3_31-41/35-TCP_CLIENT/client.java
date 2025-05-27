import java.io.*;
import java.net.*;

public class client{
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            System.out.println("Connected to server.");
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String serverMsg, clientMsg;
            while (true) {
                if (in.ready()) {
                    serverMsg = in.readLine();
                    if (serverMsg == null || serverMsg.equalsIgnoreCase("exit")) {
                        System.out.println("Server disconnected.");
                        break;
                    }
                    System.out.println("Server: " + serverMsg);
                }
                if (userInput.ready()) {
                    clientMsg = userInput.readLine();
                    out.println(clientMsg);
                    if (clientMsg.equalsIgnoreCase("exit")) {
                        System.out.println("Client closing.");
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}