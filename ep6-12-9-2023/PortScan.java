import java.net.*;
import java.io.*;

public class PortScan {
    public static void main(String[] args) {
        for (int i = 70; i <= 100; i++) {
            try {
                if (args.length != 1) {
                    System.out.println("Usage : java PortScan <Hostname/IP>");
                    System.exit(0);
                }

                // int i =15;
                Socket socket = new Socket(args[0], i);
                socket.close();
                System.out.println("port : " + i + " open");

            } catch (Exception e) {

            }
        }
    }
}
