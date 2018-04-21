import java.net.*;
import java.util.ArrayList;
import java.io.*;
public class Server {
	
	static ArrayList<Online> online = null;
	
	public static <ClientServerThread> void main(String[] args) throws Exception {
		
		
		try{
			ServerSocket server=new ServerSocket(8888);
			while(true){
				Socket client = server.accept();
				ServerClientThread sct = new ServerClientThread(client);
				sct.start();
			}
		}catch(Exception e){
			System.out.println(e);	
		}
	}
}