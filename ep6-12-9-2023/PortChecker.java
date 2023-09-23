import java.net.Socket;

public class PortChecker {
    public static void main(String[] args) {
        String host = "example.com"; // Replace with the host you want to check
        int port = 80; // Replace with the port you want to check

        try {
            Socket socket = new Socket(host, port);
            socket.close();
            System.out.println("Port " + port + " on " + host + " is open.");
        } catch (Exception e) {
            System.out.println("Port " + port + " on " + host + " is closed.");
        }
    }
}
