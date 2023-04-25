import java.sql.*;

import static java.lang.Class.forName;

public class DBCompteBancaire {

    Connection con=null;
    public  void Connectionbd (){

         try {
             forName("com.mysql.jdbc.Driver");
             String url = "jdbc:mysql://localhost/compte_bancaire";
             con = DriverManager.getConnection(url,"root","");





             System.out.println("connecter avec success");


        } catch (SQLException e) {
             throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
             throw new RuntimeException(e);
         }

    }

}
