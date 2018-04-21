import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerClientThread extends Thread {
	private Socket client;
	
	public ServerClientThread(Socket c) {
		this.client=c;
	}
	public void run(){
		try{
			ObjectInputStream inputStream = new ObjectInputStream(client.getInputStream());
			Packet packet = (Packet) inputStream.readObject();
			if (packet.getType() == PacketType.LOGIN) {
				SignIn signIn=(SignIn) packet.getData();
				
				Server.online.add(new Online(signIn.getUserNo(), client));
			}
			
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}