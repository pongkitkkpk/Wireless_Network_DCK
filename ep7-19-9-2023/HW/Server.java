import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.*;

public class Server implements Runnable {
    static int PORT = 23410;
    static int MAX_THREADS = 15;
    static HashMap<Integer, String> dataStore = new HashMap<>();

    private final Socket clientSocket;

    Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(
                                 new InputStreamReader(
                                 clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String request = in.readLine();
            String[] parts = request.split(" ");

            if (parts.length >= 2) {
                String command = parts[0];
                int id = Integer.parseInt(parts[1]);

                if (command.equals("add") && parts.length >= 3) {
                    String name = parts[2];
                    dataStore.put(id, name);
                    out.println("OK");
                } else if (command.equals("search")) {
                    String name = dataStore.get(id);
                    if (name != null) {
                        out.println( name);
                    } else {
                        out.println("N/A");
                    }
                } else {
                    out.println("Invalid command.");
                }
            } else {
                out.println("Invalid request.");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running and listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                Server clientHandler = new Server(clientSocket);
                threadPool.execute(clientHandler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
