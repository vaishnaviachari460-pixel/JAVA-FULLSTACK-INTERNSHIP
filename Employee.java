package sqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Employee {

    static final String URL = "jdbc:mysql://localhost:3306/mydb1";
    static final String USER = "root";
    static final String PASSWORD = "root@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Insert Employee");
                System.out.println("2. Update Employee");
                System.out.println("3. Delete Employee");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT
                    case 1 -> {
                        System.out.print("Enter Employee ID: ");
                        int empId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter City: ");
                        String city = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phNo = sc.nextLine();

                        String insertQuery =
                                "INSERT INTO Employee (empId, name, city, salary, PhNo) VALUES (?, ?, ?, ?, ?)";

                        try (PreparedStatement stmt = conn.prepareStatement(insertQuery)) {
                            stmt.setInt(1, empId);
                            stmt.setString(2, name);
                            stmt.setString(3, city);
                            stmt.setDouble(4, salary);
                            stmt.setString(5, phNo);

                            int rows = stmt.executeUpdate();
                            if (rows > 0)
                                System.out.println("Employee inserted successfully!");
                        }
                    }

                    // UPDATE
                    case 2 -> {
                        System.out.print("Enter Employee ID to update: ");
                        int empId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter new City: ");
                        String city = sc.nextLine();

                        System.out.print("Enter new Salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        System.out.print("Enter new Phone Number: ");
                        String phNo = sc.nextLine();

                        String updateQuery =
                                "UPDATE Employee SET name=?, city=?, salary=?, PhNo=? WHERE empId=?";

                        try (PreparedStatement stmt = conn.prepareStatement(updateQuery)) {
                            stmt.setString(1, name);
                            stmt.setString(2, city);
                            stmt.setDouble(3, salary);
                            stmt.setString(4, phNo);
                            stmt.setInt(5, empId);

                            int rows = stmt.executeUpdate();
                            if (rows > 0)
                                System.out.println("Employee updated successfully!");
                            else
                                System.out.println("Employee ID not found!");
                        }
                    }

                    // DELETE
                    case 3 -> {
                        System.out.print("Enter Employee ID to delete: ");
                        int empId = sc.nextInt();

                        String deleteQuery =
                                "DELETE FROM Employee WHERE empId=?";

                        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
                            stmt.setInt(1, empId);

                            int rows = stmt.executeUpdate();
                            if (rows > 0)
                                System.out.println("Employee deleted successfully!");
                            else
                                System.out.println("Employee ID not found!");
                        }
                    }

                    case 4 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        return;
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}