import java.net.Socket;

public class Online {
	
	private String userNo;
	private	Socket	socket;
	
	
	
	public Online(String userNo, Socket socket) {
		this.userNo = userNo;
		this.socket = socket;
	}

	public String getUserNo() {
		return userNo;
	}
	
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
	public Socket getSocket() {
		return socket;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}
	
	

}
