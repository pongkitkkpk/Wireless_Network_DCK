import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.*;

public class printWriter {
    public static void main(String[] args) {
        try{
            String msg = "Helloaaaaa World";
            File f = new File("AA.txt");
            FileOutputStream fout = new FileOutputStream(f);
            PrintWriter pout = new PrintWriter(fout);
            pout.print(msg);
            pout.flush();
            fout.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
