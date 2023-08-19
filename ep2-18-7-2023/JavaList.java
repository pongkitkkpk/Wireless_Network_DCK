import java.io.*;

public class JavaList {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage : JavaList  <File/Directory Name>");
        } else {
            String path = args[0];
            // C:/Users/pongk/DCK/ep2-18-7-2023/AA.txt
            File f = new File(path);

            if (f.isFile()) {
                double txtlong = f.length();
                String txtname = f.getName();
                System.out.println(txtname + " have " + txtlong + " Bytes");
            } else if (f.isDirectory()) {
                File list[] = f.listFiles();
                for (int i = 0; i < list.length; i++) {
                    if (list[i].isFile()) {
                        double txtlong = list[i].length();
                        String txtname = list[i].getName();
                        System.out.println(txtname + " have " + txtlong + " Bytes");
                    } else {
                        String txtname = list[i].getName();
                        System.out.println(txtname);
                    }
                }
            } else if (!(f.isFile()) && !(f.isDirectory())) {
                System.out.println("File not found");
            }
        }

    }
}
