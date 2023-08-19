import java.io.*;

public class Exol{
    public static void main(String[] args) {
        if(args.length != 2){
            System.out.println("please enter 2 args");
            System.exit(1);
        }
        int num1 = Integer.parseInt(args[0]);
        int num2 = Integer.parseInt(args[1]);
        System.out.println("Result ="+(num1+num2));
    }
}