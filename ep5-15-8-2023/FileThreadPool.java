
import java.io.*;
import java.util.concurrent.*;


public class FileThreadPool implements Runnable {
   public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        try{
            String path = args[0];
            File f = new File(path);
            // BufferedReader br =new BufferedReader(new FileReader(f));
            BufferedReader br =new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String line;
            while((line = br.readLine()) != null){
                es.execute(new FileThreadPool(line));
            }
            br.close();
        }catch(Exception e){}
        es.shutdown();
   }

   public String line;

   public FileThreadPool (String line){
    this.line = line;
   }

   public void run(){
    int n =Integer.parseInt(line);
    int result = n*n;
    System.out.println(line +"->"+ result);
   }

  
}