import java.sql.*;

public class DatabaseManager {

    private String connectionString= "jdbc:mysql://localhost/segp";
    private Connection conn = null;
    private Statement st = null;
    private ResultSet rs = null;
    public DatabaseManager() {
        // TODO Auto-generated constructor stub
        createConnection();
    }
    synchronized void createConnection() {
        try {
            if(conn==null || conn.isClosed() ){
                conn = DriverManager.getConnection(connectionString, "root", "");
                st = conn.createStatement();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean addNewUser(SignUp signup){
        //createConnection();
        try {
            System.out.println(""+signup.getUserNo());
            if(isUserNoValid(signup.getUserNo())) {
                String sql="insert into users(user_no,password,first_name,last_name,img,status) values(?,?,?,?,?,?)";
                PreparedStatement pst=conn.prepareStatement(sql);

                String userNo=signup.getUserNo();
                String password=signup.getPassword();
                String firstName=signup.getFirstName();
                String lastName=signup.getLastName();
                String status=signup.getStatus();

                pst.setString(1,userNo);
                pst.setString(2, password);
                pst.setString(3, firstName);
                pst.setString(4, lastName);
                pst.setBytes(5, signup.getImage());
                pst.setString(6, status);
                pst.executeUpdate();

                return true;
            }
            else
                return false;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean getUserSignIn(SignIn signIn){
        //createConnection();
        try {
            System.out.println(""+signIn.getUserNo());

            rs=st.executeQuery("select * from users where user_no='"+signIn.getUserNo()+"'");
            rs.next();
            if(rs.getString(1).equals(signIn.getUserNo()) && rs.getString(2).equals(signIn.getPassword())){
                return true;
            }
            else {
                return false;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean addNewMassage(Massage massage){

        String senderNo=massage.getSenderNo();
        String receiverNo=massage.getReceiverNo();
        //long timeStamp=massage.getTimeStamp();
        String textData=massage.getTextData();
        byte[] imgData=massage.getImageData();

        try {
            String sql="insert into massages(sender_no,receiver_no,text_data,image_data) values(?,?,?,?)";
            PreparedStatement pst=conn.prepareStatement(sql);

            pst.setString(1,senderNo);
            pst.setString(2,receiverNo);
           // pst.setLong(3,timeStamp);
            pst.setString(3,textData);
            pst.setBytes(4,imgData);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

     //   return false;
    }

    public boolean isUserNoValid(String userNo){
        try {

            rs=st.executeQuery("select user_no from users where user_no='"+userNo+"'");
            while(rs.next()){
                if(rs.getString(1).equals(userNo)){
                    return false;
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return true;
    }


}
