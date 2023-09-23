import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 23410;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            
                System.out.print("Enter a command: ");
                String input = userInput.readLine();
                out.println(input);

                String response = in.readLine();
                System.out.println("Server response: " + response);
                
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
