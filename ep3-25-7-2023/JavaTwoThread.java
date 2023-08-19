import java.io.*;

public class JavaTwoThread implements Runnable {
    int from;
    int where;
    int result = 0;
    public JavaTwoThread(int from, int where) {
        this.from = from;
        this.where = where;
        
    }
    public void run() {
        for (int i = from; i <= where; i++) {
            result += i;
        }

    }
    public int getResult() {
        return (result);
    }

    public static void main(String[] args) {
        int total = 0;
        JavaTwoThread s1 = new JavaTwoThread(0, 4999);
        JavaTwoThread s2 = new JavaTwoThread(5000, 10000);
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s2);
        try {
            t1.start();
            t2.start();

            t1.join();
            System.out.println("t1 = " + s1.getResult());
            Thread.sleep(5000);

            t2.join();
            System.out.println("t2 = " + s2.getResult());
            Thread.sleep(10000);

            total = s1.getResult() + s2.getResult();
        } catch (Exception e) {
        }

        System.out.print("Result = " + total);
    }

}
