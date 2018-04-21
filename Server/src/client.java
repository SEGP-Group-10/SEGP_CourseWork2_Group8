import java.net.Socket;

public class client {

    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("192.168.40.253",8888);
    }
}
