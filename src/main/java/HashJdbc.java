import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class HashJdbc {

    private String url;
    private  int port;
//    数据库连接
//    public  void setConnect(String url,int port){
//        Connection connection=null;
//        Class.forName("com.mysql.jdbc.Driver");
//        connection = DriverManager.getConnection("jdbc:mysql://wsd-projecta.master.mysql.pre.dba.unp.oyw:13306","web_cm_user", "web_cm_user");
//        Statement statement=connection.createStatement();
//        statement.execute(this.getSql());
//
//    }
// sql生成--did
    public String getSql(String did){
    return "";
    }
// sql生成--uid
    public String getSql(int uid){
        Hashing hashing = new Hashing();
        int sufix=hashing.getHash(uid);
        int databaseNum=sufix%4;
        int tableNum=hashing.getHash(uid);
        String s=String.format("use database dy_member_label_"+databaseNum+";"+"select * from member_label_"+tableNum+";");
        return s;
    }


    public static void main(String[] args){
        HashJdbc hashJdbc=new HashJdbc();
        hashJdbc.getSql(101367);
    }




}
