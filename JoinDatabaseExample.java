package sqlDemo;

import java.sql.*;

public class JoinDatabaseExample {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root@123";

        try {

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            // Create Database
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS joindb");
            st.execute("USE joindb");

            // Create Tables
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Students (" +
                    "student_id INT PRIMARY KEY, name VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Clubs (" +
                    "club_id INT PRIMARY KEY, club_name VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Student_Club (" +
                    "student_id INT, club_id INT)");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Users (" +
                    "user_id INT PRIMARY KEY, name VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Subscriptions (" +
                    "sub_id INT PRIMARY KEY, user_id INT, plan VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Authors (" +
                    "author_id INT PRIMARY KEY, author_name VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Books (" +
                    "book_id INT PRIMARY KEY, title VARCHAR(100), author_id INT)");

            System.out.println("Tables Created");

            // Insert Data
            st.executeUpdate("INSERT INTO Students VALUES (1,'Rahul'),(2,'Priya'),(3,'Amit'),(4,'Neha')");
            st.executeUpdate("INSERT INTO Clubs VALUES (101,'Robotics'),(102,'Photography')");
            st.executeUpdate("INSERT INTO Student_Club VALUES (1,101),(2,102),(3,101)");

            st.executeUpdate("INSERT INTO Users VALUES (1,'Arjun'),(2,'Sneha'),(3,'Karan'),(4,'Meera')");
            st.executeUpdate("INSERT INTO Subscriptions VALUES (201,1,'Premium'),(202,2,'Basic')");

            st.executeUpdate("INSERT INTO Authors VALUES (1,'R.K. Narayan'),(2,'Chetan Bhagat')");
            st.executeUpdate("INSERT INTO Books VALUES (301,'Malgudi Days',1),(302,'Five Point Someone',2),(303,'Unknown Mystery',NULL)");

            System.out.println("Data Inserted");

            ResultSet rs;

            // INNER JOIN
            System.out.println("\nINNER JOIN Result:");
            rs = st.executeQuery("SELECT s.name, c.club_name " +
                    "FROM Students s " +
                    "INNER JOIN Student_Club sc ON s.student_id = sc.student_id " +
                    "INNER JOIN Clubs c ON sc.club_id = c.club_id");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getString("club_name"));
            }

            // LEFT JOIN
            System.out.println("\nLEFT JOIN Result:");
            rs = st.executeQuery("SELECT u.name, s.plan " +
                    "FROM Users u " +
                    "LEFT JOIN Subscriptions s ON u.user_id = s.user_id");

            while (rs.next()) {
                System.out.println(rs.getString("name") + " - " + rs.getString("plan"));
            }

            // RIGHT JOIN
            System.out.println("\nRIGHT JOIN Result:");
            rs = st.executeQuery("SELECT b.title, a.author_name " +
                    "FROM Authors a " +
                    "RIGHT JOIN Books b ON a.author_id = b.author_id");

            while (rs.next()) {
                System.out.println(rs.getString("title") + " - " + rs.getString("author_name"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}