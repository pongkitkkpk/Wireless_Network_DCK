import java.io.*;

class JavaThread extends Thread {
    int member;

    public JavaThread(int member) {
        this.member = member;
    }

    public static void main(String[] args) {

        int member = Integer.parseInt(args[0]);
        JavaThread[] mt = new JavaThread[member];
        for (int i = 0; i < mt.length; i++) {
            mt[i] = new JavaThread(i);
            mt[i].start();
        }

    }
// ***********************
    public void run() {
        System.out.println(member + " Helloworld ");

    }

}
