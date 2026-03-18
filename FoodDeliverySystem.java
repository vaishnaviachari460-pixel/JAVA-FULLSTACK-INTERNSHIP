package mongodemo;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Accumulators.*;
import static com.mongodb.client.model.Sorts.descending;

public class FoodDeliverySystem {

    static MongoClient client = MongoClients.create("");
    static MongoDatabase db = client.getDatabase("foodDB");
    static MongoCollection<Document> orders = db.getCollection("orders");

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== SMART FOOD DELIVERY SYSTEM =====");
            System.out.println("1. Insert Sample Data");
            System.out.println("2. View All Orders");
            System.out.println("3. Orders by City");
            System.out.println("4. Delivered Orders");
            System.out.println("5. Total Revenue by City");
            System.out.println("6. Most Ordered Food Item");
            System.out.println("7. Avg Order Value per Restaurant");
            System.out.println("8. Order Status Count");
            System.out.println("9. Price > 300 (Descending)");
            System.out.println("10. Create Index");
            System.out.println("11. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    insertData();
                    break;
                case 2:
                    viewAll();
                    break;
                case 3:
                    ordersByCity();
                    break;
                case 4:
                    deliveredOrders();
                    break;
                case 5:
                    revenueByCity();
                    break;
                case 6:
                    mostOrderedItem();
                    break;
                case 7:
                    avgByRestaurant();
                    break;
                case 8:
                    statusCount();
                    break;
                case 9:
                    priceGreaterThan300();
                    break;
                case 10:
                    createIndexes();
                    break;
                case 11:
                    System.exit(0);
            }
        }
    }

    // ================= INSERT =================
    static void insertData() {

        orders.insertMany(java.util.Arrays.asList(

                new Document("order_id", 101)
                        .append("customer_name", "Rahul")
                        .append("restaurant", "Pizza Hut")
                        .append("food_item", "Pizza")
                        .append("quantity", 2)
                        .append("price", 500)
                        .append("city", "Bangalore")
                        .append("status", "Delivered"),

                new Document("order_id", 102)
                        .append("customer_name", "Anjali")
                        .append("restaurant", "KFC")
                        .append("food_item", "Burger")
                        .append("quantity", 1)
                        .append("price", 250)
                        .append("city", "Hyderabad")
                        .append("status", "Pending"),

                new Document("order_id", 103)
                        .append("customer_name", "Vikram")
                        .append("restaurant", "Dominos")
                        .append("food_item", "Pizza")
                        .append("quantity", 3)
                        .append("price", 750)
                        .append("city", "Bangalore")
                        .append("status", "Delivered"),

                new Document("order_id", 104)
                        .append("customer_name", "Sneha")
                        .append("restaurant", "McDonalds")
                        .append("food_item", "Fries")
                        .append("quantity", 2)
                        .append("price", 200)
                        .append("city", "Chennai")
                        .append("status", "Pending"),

                new Document("order_id", 105)
                        .append("customer_name", "Arjun")
                        .append("restaurant", "KFC")
                        .append("food_item", "Chicken")
                        .append("quantity", 2)
                        .append("price", 600)
                        .append("city", "Bangalore")
                        .append("status", "Delivered")
        ));

        System.out.println("Sample Data Inserted!");
    }

    // ================= READ =================
    static void viewAll() {
        for (Document d : orders.find()) {
            System.out.println(d.toJson());
        }
    }

    static void ordersByCity() {
        sc.nextLine();
        System.out.print("Enter City: ");
        String city = sc.nextLine();

        for (Document d : orders.find(eq("city", city))) {
            System.out.println(d.toJson());
        }
    }

    static void deliveredOrders() {
        for (Document d : orders.find(eq("status", "Delivered"))) {
            System.out.println(d.toJson());
        }
    }

    // ================= AGGREGATION =================

    static void revenueByCity() {
        AggregateIterable<Document> result = orders.aggregate(java.util.Arrays.asList(
                new Document("$group",
                        new Document("_id", "$city")
                                .append("totalRevenue", new Document("$sum", "$price")))
        ));

        for (Document d : result) {
            System.out.println(d.toJson());
        }
    }

    static void mostOrderedItem() {
        AggregateIterable<Document> result = orders.aggregate(java.util.Arrays.asList(
                new Document("$group",
                        new Document("_id", "$food_item")
                                .append("totalOrders", new Document("$sum", "$quantity"))),
                new Document("$sort", new Document("totalOrders", -1)),
                new Document("$limit", 1)
        ));

        for (Document d : result) {
            System.out.println(d.toJson());
        }
    }

    static void avgByRestaurant() {
        AggregateIterable<Document> result = orders.aggregate(java.util.Arrays.asList(
                new Document("$group",
                        new Document("_id", "$restaurant")
                                .append("avgPrice", new Document("$avg", "$price")))
        ));

        for (Document d : result) {
            System.out.println(d.toJson());
        }
    }

    static void statusCount() {
        AggregateIterable<Document> result = orders.aggregate(java.util.Arrays.asList(
                new Document("$group",
                        new Document("_id", "$status")
                                .append("count", new Document("$sum", 1)))
        ));

        for (Document d : result) {
            System.out.println(d.toJson());
        }
    }

    // ================= ADVANCED =================

    static void priceGreaterThan300() {
        for (Document d : orders.find(gt("price", 300)).sort(descending("price"))) {
            System.out.println(d.toJson());
        }
    }

    // ================= INDEX =================

    static void createIndexes() {
        orders.createIndex(new Document("customer_name", 1));
        orders.createIndex(new Document("city", 1));
        System.out.println("Indexes Created!");
    }
}