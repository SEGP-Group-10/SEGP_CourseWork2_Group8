import com.example.muzammil.prolife.commclasses.*;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ServerClientThread extends Thread {
    private Socket client;

    public ServerClientThread(Socket c) {
        this.client=c;
    }


    public static byte[] serialize(Object obj) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(obj);
        return out.toByteArray();
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }


    public void run(){

        System.out.println("Thread started for:"+client.getInetAddress());

        DatabaseManager databaseManager=new DatabaseManager();
        try{
            InputStreamReader inputStreamReader=new InputStreamReader(client.getInputStream());
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);

            System.out.println("Before datainputStream obj.");
            DataInputStream dataInputStream=new DataInputStream(client.getInputStream());
            System.out.println("After datainputStream obj.");



/*
            System.out.println("Before inputStream obj.");
            ObjectInputStream inputStream=new ObjectInputStream(client.getInputStream());
            System.out.println("After inputStream obj.");
*/

            while(client.isConnected()){
                /*if(client.isConnected()==false){
                    System.out.println("Client Ip:"+client.getInetAddress()+" is no more connected");
                    break;
                }*/

                byte[] b=new byte[100000];
                int count=dataInputStream.read(b,0,b.length);

                System.out.println("Total bytes readed:"+count);

                System.out.println("Before reading packet.");

                Object object=deserialize(b);
                Packet packet= (Packet) object;
                System.out.println("After reading packet.");
                if(packet.getType()==PacketType.SIGNUP){
                    System.out.println("Packet is of type SignUp.");
                    SignUp signUp= (SignUp) packet.getData();
                    System.out.println("Packet data is asgined to signup obj.");
                    Boolean isValid=databaseManager.addNewUser(signUp);
                    System.out.println("Is a valid user return: "+isValid);
                    if(isValid==true){
                        //Server.online.add(new Online(signUp.getUserNo(), client));

                        byte[] p=serialize(new Packet(PacketType.SIGNUP_RESPONSE,new Response(ResponseType.SIGNUP_OK)));
                        System.out.println("After creating packet.");

                        DataOutputStream dataOutputStream=new DataOutputStream(client.getOutputStream());

                        dataOutputStream.write(p);
                        dataOutputStream.flush();
                        dataOutputStream.close();

                        /*System.out.println("Before outputStream obj.");
                        ObjectOutputStream outputStream=new ObjectOutputStream(client.getOutputStream());
                        System.out.println("After geting outputStream.");
                        outputStream.writeObject(new Packet(PacketType.SIGNUP_RESPONSE,new Response(ResponseType.SIGNUP_OK)));
                        outputStream.flush();
                        System.out.println("After writing obj");*/
                    }
                    else{

                        byte[] p=serialize(new Packet(PacketType.SIGNUP_RESPONSE,new Response(ResponseType.SIGNUP_INVALID_NO)));

                        DataOutputStream dataOutputStream=new DataOutputStream(client.getOutputStream());

                        dataOutputStream.write(p);
                        dataOutputStream.flush();
                        dataOutputStream.close();

                        /*System.out.println("Before outputStream obj.");
                        ObjectOutputStream outputStream=new ObjectOutputStream(client.getOutputStream());
                        System.out.println("After outputStream obj.");
                        outputStream.writeObject(new Packet(PacketType.SIGNUP_RESPONSE,new Response(ResponseType.SIGNUP_INVALID_NO)));
                        System.out.println("After writing  obj.");*/
                    }
                }


                /*if (packet.getType() == PacketType.LOGIN) {
                    SignIn signIn=(SignIn) packet.getData();

                    if(databaseManager.getUserSignIn(signIn)==true){
                        Server.online.add(new Online(signIn.getUserNo(), client));
                    }

                }*/
            }

            client.close();



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            //e.printStackTrace();
        }
    }
}