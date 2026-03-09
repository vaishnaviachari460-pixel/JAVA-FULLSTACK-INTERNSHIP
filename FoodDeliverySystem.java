package sqlDemo;

import java.sql.*;

public class FoodDeliverySystem {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "root@123"; // change if your MySQL has password

        try {

            // Step 1: Connect to MySQL Server
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();

            // Step 2: Create Database
            st.executeUpdate("CREATE DATABASE IF NOT EXISTS fooddb");
            System.out.println("Database created successfully");

            // Step 3: Use Database
            st.execute("USE fooddb");

            // Step 4: Create Tables

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Customers (" +
                    "customer_id INT PRIMARY KEY," +
                    "name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "phone VARCHAR(15))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Restaurants (" +
                    "restaurant_id INT PRIMARY KEY," +
                    "restaurant_name VARCHAR(50)," +
                    "city VARCHAR(50)," +
                    "rating FLOAT)");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Food_Items (" +
                    "food_id INT PRIMARY KEY," +
                    "food_name VARCHAR(50)," +
                    "price INT," +
                    "restaurant_id INT," +
                    "FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id))");

            st.executeUpdate("CREATE TABLE IF NOT EXISTS Orders (" +
                    "order_id INT PRIMARY KEY," +
                    "customer_id INT," +
                    "food_id INT," +
                    "quantity INT," +
                    "order_date DATE," +
                    "FOREIGN KEY (customer_id) REFERENCES Customers(customer_id)," +
                    "FOREIGN KEY (food_id) REFERENCES Food_Items(food_id))");

            System.out.println("Tables created successfully");

            // Step 5: Insert Data

            st.executeUpdate("INSERT INTO Customers VALUES " +
                    "(1,'Amit','Bangalore','9876543210')," +
                    "(2,'Anita','Chennai','9876543211')," +
                    "(3,'Rahul','Mumbai','9876543212')");

            st.executeUpdate("INSERT INTO Restaurants VALUES " +
                    "(1,'Pizza Hut','Bangalore',4.2)," +
                    "(2,'Dominos','Chennai',4.0)," +
                    "(3,'Burger King','Mumbai',4.1)");

            st.executeUpdate("INSERT INTO Food_Items VALUES " +
                    "(101,'Veg Pizza',250,1)," +
                    "(102,'Chicken Pizza',300,1)," +
                    "(103,'Burger',150,3)," +
                    "(104,'Pasta',200,2)");

            st.executeUpdate("INSERT INTO Orders VALUES " +
                    "(1,1,101,2,'2026-03-01')," +
                    "(2,2,104,1,'2026-03-02')," +
                    "(3,3,103,3,'2026-03-03')");

            System.out.println("Data inserted successfully");

            ResultSet rs;

            // Task 1 – SELECT
            System.out.println("\nAll Food Items:");
            rs = st.executeQuery("SELECT * FROM Food_Items");
            while (rs.next()) {
                System.out.println(rs.getInt("food_id") + " "
                        + rs.getString("food_name") + " "
                        + rs.getInt("price"));
            }

            // Task 2 – WHERE
            System.out.println("\nFood items costing more than 200:");
            rs = st.executeQuery("SELECT * FROM Food_Items WHERE price > 200");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " " + rs.getInt("price"));
            }

            // Task 3 – AND
            System.out.println("\nFood items price >150 AND restaurant_id=2:");
            rs = st.executeQuery("SELECT * FROM Food_Items WHERE price >150 AND restaurant_id=2");
            while (rs.next()) {
                System.out.println(rs.getString("food_name"));
            }

            // Task 3 – OR
            System.out.println("\nRestaurants in Chennai OR Bangalore:");
            rs = st.executeQuery("SELECT * FROM Restaurants WHERE city='Chennai' OR city='Bangalore'");
            while (rs.next()) {
                System.out.println(rs.getString("restaurant_name"));
            }

            // Task 4 – LIKE
            System.out.println("\nCustomers whose name starts with A:");
            rs = st.executeQuery("SELECT * FROM Customers WHERE name LIKE 'A%'");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }

            System.out.println("\nFood items containing Pizza:");
            rs = st.executeQuery("SELECT * FROM Food_Items WHERE food_name LIKE '%Pizza%'");
            while (rs.next()) {
                System.out.println(rs.getString("food_name"));
            }

            // Task 5 – BETWEEN
            System.out.println("\nFood items priced between 100 and 300:");
            rs = st.executeQuery("SELECT * FROM Food_Items WHERE price BETWEEN 100 AND 300");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " " + rs.getInt("price"));
            }

            // Task 6 – ORDER BY
            System.out.println("\nFood items sorted by price (High to Low):");
            rs = st.executeQuery("SELECT * FROM Food_Items ORDER BY price DESC");
            while (rs.next()) {
                System.out.println(rs.getString("food_name") + " " + rs.getInt("price"));
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}