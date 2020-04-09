import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {

    private static Database database = new Database();
    private static Statement statement;


    private Database() {}

    public static Database getInstance() {
        if(database == null)
         database = new Database();
        return database;
    }

    public void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "student", "student");
            this.statement = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Statement getStatement() {
        return statement;
    }

    public void closeConn(){
        database.closeConn();
    }



}



