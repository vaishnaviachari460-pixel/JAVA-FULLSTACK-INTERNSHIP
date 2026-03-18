package sqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.CallableStatement;
import java.sql.ResultSet;

public class stored_procedure {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hospital_db",
                    "root",
                    "root@123");

            CallableStatement cs = con.prepareCall(
                    "{CALL book_appointment(?,?,?)}");

            cs.setInt(1, 3);  // patient_id
            cs.setInt(2, 1);  // doctor_id
            cs.setDate(3, java.sql.Date.valueOf("2026-03-15"));

            ResultSet rs = cs.executeQuery();

            while(rs.next()) {
                System.out.println(rs.getString("message"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}