import com.example.muzammil.prolife.commclasses.Massage;

import java.net.*;
import java.util.ArrayList;
import java.io.*;
public class Server {


    public static ArrayList<Online> online = null;

    public static ArrayList<Massage> pendingMassages=null;

    public Server(){
        online=new ArrayList<Online>();
        pendingMassages=new ArrayList<Massage>();
    }

    public static void main(String[] args) throws Exception {
        int request=0;

        try{
            ServerSocket server=new ServerSocket(8888);
            System.out.println("Server IP address: "+server.getInetAddress());
            System.out.println("Server IP address: "+server.getLocalPort());
            System.out.println("Server IP address: ");


            while(true){
                Socket client = server.accept();
                System.out.println("Request #"+request+" is Accepted from IP:"+client.getInetAddress());
                request++;

                ServerClientThread sct = new ServerClientThread(client);
                sct.start();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}