import java.sql.*;

public class HashJdbc {

    private String url;
    private  int port;
//    数据库连接
    public  void setConnect() throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://10.1.104.15:3323/dy_adx_anchor","test_vod_web", "N257OBuUjsxs1Vh9A5dA");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(this.getSql());
        System.out.println(resultSet);

    }
// sql生成--did
    public String getSql(){
    return "select * from `ada_account`";
    }
// sql生成--uid
//    public String getSql(int uid){
//        Hashing hashing = new Hashing();
//        int sufix=hashing.getHash(uid);
//        int databaseNum=sufix%4;
//        int tableNum=hashing.getHash(uid);
//        String s=String.format("use database dy_member_label_"+databaseNum+";"+"select * from member_label_"+tableNum+";");
//        return s;
//    }


    public static void main(String[] args){
        HashJdbc hashJdbc=new HashJdbc();
        try {
            hashJdbc.setConnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}
