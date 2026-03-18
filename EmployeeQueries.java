package sqlDemo;

import java.sql.*;

public class EmployeeQueries {

    public static void main(String[] args) {

        try {
            // Load MySQL Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL (no database selected yet)
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/", "root", "root@123");

            Statement st = con.createStatement();

            // 1. Create Database
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS companydb");
            System.out.println("Database created successfully");

            // 2. Use Database
            st.executeUpdate("USE companydb");

            // 3. Create Tables
            st.executeUpdate("CREATE TABLE IF NOT EXISTS Departments("
                    + "dept_id INT PRIMARY KEY, "
                    + "dept_name VARCHAR(50))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Employees("
                    + "emp_id INT PRIMARY KEY, "
                    + "name VARCHAR(50), "
                    + "salary INT, "
                    + "dept_id INT)");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Projects("
                    + "project_id INT PRIMARY KEY, "
                    + "emp_id INT, "
                    + "project_name VARCHAR(100))");

            System.out.println("Tables created successfully");

            // 4. Insert Data
            st.executeUpdate("INSERT INTO Departments VALUES (1,'IT'),(2,'HR'),(3,'Finance')");
            st.executeUpdate("INSERT INTO Employees VALUES "
                    + "(1,'Ravi',50000,1),"
                    + "(2,'Meena',70000,2),"
                    + "(3,'Arun',60000,1),"
                    + "(4,'Kiran',45000,2),"
                    + "(5,'Pooja',80000,3)");

            st.executeUpdate("INSERT INTO Projects VALUES "
                    + "(101,1,'AI System'),"
                    + "(102,2,'Payroll App'),"
                    + "(103,3,'Database Tool'),"
                    + "(104,5,'Finance Tracker')");

            System.out.println("Data inserted successfully");

            // -------------------------
            // Query 1
            // -------------------------
            System.out.println("\nEmployees with salary greater than average:");

            ResultSet rs1 = st.executeQuery(
                    "SELECT name,salary FROM Employees WHERE salary > (SELECT AVG(salary) FROM Employees)");

            while (rs1.next()) {
                System.out.println(rs1.getString("name") + " " + rs1.getInt("salary"));
            }

            // -------------------------
            // Query 2
            // -------------------------
            System.out.println("\nEmployees in IT or Finance:");

            ResultSet rs2 = st.executeQuery(
                    "SELECT name FROM Employees WHERE dept_id IN "
                    + "(SELECT dept_id FROM Departments WHERE dept_name IN ('IT','Finance'))");

            while (rs2.next()) {
                System.out.println(rs2.getString("name"));
            }

            // -------------------------
            // Query 3
            // -------------------------
            System.out.println("\nEmployees earning more than department average:");

            ResultSet rs3 = st.executeQuery(
                    "SELECT name,salary,dept_id FROM Employees e "
                    + "WHERE salary > (SELECT AVG(salary) FROM Employees WHERE dept_id=e.dept_id)");

            while (rs3.next()) {
                System.out.println(rs3.getString("name") + " "
                        + rs3.getInt("salary") + " "
                        + rs3.getInt("dept_id"));
            }

            // -------------------------
            // Query 4
            // -------------------------
            System.out.println("\nEmployees working on IT department projects:");

            ResultSet rs4 = st.executeQuery(
                    "SELECT name FROM Employees WHERE emp_id IN "
                    + "(SELECT emp_id FROM Projects WHERE emp_id IN "
                    + "(SELECT emp_id FROM Employees WHERE dept_id = "
                    + "(SELECT dept_id FROM Departments WHERE dept_name='IT')))");

            while (rs4.next()) {
                System.out.println(rs4.getString("name"));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}