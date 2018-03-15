public class test {

    public static void main(String[] args){
        
        byte[] b=null;
        Massage massage=new Massage("12345","54321","HelloTest Again",b);

        DatabaseManager db=new DatabaseManager();
        db.addNewMassage(massage);
    }
}
