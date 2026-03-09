package sqlDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo {

    static final String URL = "jdbc:mysql://localhost:3306/mydb";
    static final String USER = "root";
    static final String PASSWORD = "root@123";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to database!");

            while (true) {
                System.out.println("\n1. Insert");
                System.out.println("2. Update");
                System.out.println("3. Delete");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    // INSERT
                    case 1 -> {
                        System.out.print("Enter RollNo: ");
                        int RollNo = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter City: ");
                        String city = sc.nextLine();

                        String insertQuery = 
                            "INSERT INTO student (RollNo, name, city) VALUES (?, ?, ?)";

                        try (PreparedStatement insertStmt = 
                                conn.prepareStatement(insertQuery)) {

                            insertStmt.setInt(1, RollNo);
                            insertStmt.setString(2, name);
                            insertStmt.setString(3, city);

                            int rowsInserted = insertStmt.executeUpdate();
                            if (rowsInserted > 0)
                                System.out.println("Data inserted successfully!");
                        }
                    }

                    // UPDATE
                    case 2 -> {
                        System.out.print("Enter RollNo to update: ");
                        int updateId = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter new City: ");
                        String newCity = sc.nextLine();

                        String updateQuery = 
                            "UPDATE student SET name = ?, city = ? WHERE RollNo = ?";

                        try (PreparedStatement updateStmt = 
                                conn.prepareStatement(updateQuery)) {

                            updateStmt.setString(1, newName);
                            updateStmt.setString(2, newCity);
                            updateStmt.setInt(3, updateId);

                            int rowsUpdated = updateStmt.executeUpdate();
                            if (rowsUpdated > 0)
                                System.out.println("Data updated successfully!");
                            else
                                System.out.println("RollNo not found!");
                        }
                    }

                    // DELETE
                    case 3 -> {
                        System.out.print("Enter RollNo to delete: ");
                        int deleteId = sc.nextInt();

                        String deleteQuery = 
                            "DELETE FROM student WHERE RollNo = ?";

                        try (PreparedStatement deleteStmt = 
                                conn.prepareStatement(deleteQuery)) {

                            deleteStmt.setInt(1, deleteId);

                            int rowsDeleted = deleteStmt.executeUpdate();
                            if (rowsDeleted > 0)
                                System.out.println("Data deleted successfully!");
                            else
                                System.out.println("RollNo not found!");
                        }
                    }

                    case 4 -> {
                        System.out.println("Exiting...");
                        sc.close();
                        return;   // Proper exit from loop
                    }

                    default -> System.out.println("Invalid choice!");
                }
            }

        } catch (SQLException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}