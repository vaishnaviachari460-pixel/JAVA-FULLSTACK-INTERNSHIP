package sqlDemo;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.*;

public class ConnectionPoolDemo {

    public static void main(String[] args) {

        HikariDataSource ds = null;

        try {
            
            HikariConfig config = new HikariConfig();

            config.setJdbcUrl("jdbc:mysql://localhost:3306/mydb");
            config.setUsername("root");
            config.setPassword("root@123");

            
            config.setMaximumPoolSize(10);
            config.setMinimumIdle(5);
            config.setConnectionTimeout(30000);

        
            ds = new HikariDataSource(config);

          
            Connection con = ds.getConnection();

         
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Student");

         
            while (rs.next()) {
                System.out.println(
                        rs.getInt("RollNo") + " " +
                        rs.getString("Name") + " " +
                        rs.getString("City"));
            }

         
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
         
            if (ds != null) {
                ds.close();
            }
        }
    }
}