import java.io.*;

public class JavaTextCopy {
    public static void main(String[] args) {
        if ((args.length != 2)) {
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
        }
        String nametxtmain = args[0];
        String nametxtcopy = args[1];

        try {
            String msg;
            File fmain = new File(nametxtmain);
            if (!fmain.exists()) {
                System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
                System.exit(1);
            }
            BufferedReader br = new BufferedReader(
                                new InputStreamReader(
                                new FileInputStream(fmain)));

            File fcopy = new File(nametxtcopy);
            FileOutputStream fout = new FileOutputStream(fcopy);
            PrintWriter pout = new PrintWriter(fout);
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
                pout.print(msg);
            }
            
            pout.flush();
            fout.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
