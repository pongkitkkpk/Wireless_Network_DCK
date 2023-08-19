import java.io.*;

public class JavaBinaryCopy {
    public static void main(String[] args) {
        if ((args.length != 2)) {
            System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
        }
        String nametxtmain = args[0];
        String nametxtcopy = args[1];

        try {
            int n;
            byte[] b = new byte[16];

            File fmain = new File(nametxtmain);
            if (!fmain.exists()) {
                System.out.println("Usage : java JavaBinaryCopy <source file> <destination file>");
                System.exit(1);
            }
            FileInputStream finmain = new FileInputStream(fmain);
            
            File fcopy = new File(nametxtcopy);
            FileOutputStream foutcopy = new FileOutputStream(fcopy);
            while ((n = finmain.read(b)) > 0) {
                String data = new String(b, 0, n);
                byte[] d = data.getBytes();
                foutcopy.write(d);
            }
            foutcopy.close();
            finmain.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
