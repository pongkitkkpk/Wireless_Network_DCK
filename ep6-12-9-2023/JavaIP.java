import java.net.*;

public class JavaIP {
    public static void main(String[] args) {
        try{
            if(args.length != 1 ){
                System.out.println("Usage : java JavaIP <hostname/IP>");
                System.exit(0);
            }
            InetAddress ad = InetAddress.getByName(args[0]);
            System.out.println("Host = "+ad.getHostName());
            System.out.println("IP = "+ad.getHostAddress());


        }catch(UnknownHostException e){
            System.out.println("Error : unknown host or IP address");
        }
    }
    
}
