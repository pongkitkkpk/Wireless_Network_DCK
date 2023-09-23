import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class ServerTP3 implements Runnable {
    Socket s = null;
    public ServerTP3(Socket s){
        this.s = s;
    }

    public void run(){
        try {
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                s.getInputStream()));
            PrintWriter pw = new PrintWriter(
                                 s.getOutputStream());
            
            String sleep = br.readLine();
            long sleepTime = Long.parseLong(sleep);

            try {
                Thread.sleep(sleepTime*1000);
            } catch (Exception se) {}
            
            pw.println("OK");
            pw.flush();
            pw.close();
            
        } catch (Exception e) {}
    }

    public static void main(String[] args) {
        ServerSocket serv = null;
        ExecutorService es = Executors.newFixedThreadPool(10);

        try {
            serv = new ServerSocket(30000);

        } catch (Exception e) {
            System.exit(1);
        }

        while(true){
            try {
                Socket s = serv.accept();
                ServerTP3 st = new ServerTP3(s);
                es.execute(st);
            } catch (Exception e) {}
        }
    }
}