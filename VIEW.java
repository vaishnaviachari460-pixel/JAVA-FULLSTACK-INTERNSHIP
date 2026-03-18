package sqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class VIEW {
 
    public static void main(String[] args) {

        try {

            // Step 1: Connect to MySQL Server
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "root@123");

            Statement stmt = con.createStatement();

            // Step 2: Create Database
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS university_db");

            // Step 3: Use Database
            stmt.executeUpdate("USE university_db");

            // Step 4: Create Table
            stmt.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS student_records (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "department VARCHAR(50)," +
                    "marks INT," +
                    "attendance INT)");

            // Step 5: Insert Records
            stmt.executeUpdate(
                    "INSERT IGNORE INTO student_records VALUES" +
                    "(1,'Riya','IT',92,90)," +
                    "(2,'Karan','CSE',75,80)," +
                    "(3,'Aman','ECE',85,88)," +
                    "(4,'Neha','IT',70,75)," +
                    "(5,'Rahul','CSE',95,96)," +
                    "(6,'Pooja','MBA',88,91)," +
                    "(7,'Arjun','ECE',60,70)," +
                    "(8,'Megha','IT',82,87)," +
                    "(9,'Rohit','CSE',55,65)," +
                    "(10,'Simran','MBA',78,79)");

            // Step 6: Create View
            stmt.executeUpdate(
                    "CREATE OR REPLACE VIEW scholarship_students AS " +
                    "SELECT * FROM student_records " +
                    "WHERE marks > 80 AND attendance > 85");

            // Step 7: Display Students from View
            ResultSet rs = stmt.executeQuery("SELECT * FROM scholarship_students");

            System.out.println("Students Eligible for Scholarship:\n");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("name") + " " +
                        rs.getString("department") + " " +
                        rs.getInt("marks") + " " +
                        rs.getInt("attendance"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}





