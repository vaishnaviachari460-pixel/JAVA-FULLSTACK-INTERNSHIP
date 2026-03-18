package mongodemo;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.*;

public class HostelManagementSystem {

    static MongoClient client = MongoClients.create("");
    static MongoDatabase db = client.getDatabase("hostelDB");

    static MongoCollection<Document> students = db.getCollection("students");
    static MongoCollection<Document> complaints = db.getCollection("complaints");
    static MongoCollection<Document> bookings = db.getCollection("bookings");

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n1. Student Login\n2. Admin Login\n3. Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    studentLogin();
                    break;
                case 2:
                    adminMenu();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    // ================= STUDENT =================

    static void studentLogin() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.insertOne(new Document("studentId", id).append("name", name));

        studentMenu(id);
    }

    static void studentMenu(int studentId) {
        while (true) {
            System.out.println("\n1. Raise Complaint\n2. View Complaints\n3. Book Resource\n4. Cancel Booking\n5. Logout");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    raiseComplaint(studentId);
                    break;
                case 2:
                    viewComplaints(studentId);
                    break;
                case 3:
                    bookResource(studentId);
                    break;
                case 4:
                    cancelBooking(studentId);
                    break;
                case 5:
                    return;
            }
        }
    }

    static void raiseComplaint(int studentId) {
        sc.nextLine();
        System.out.print("Enter Type (Electricity/Water/Cleanliness): ");
        String type = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        Document doc = new Document("studentId", studentId)
                .append("type", type)
                .append("description", desc)
                .append("status", "Pending");

        complaints.insertOne(doc);
        System.out.println("Complaint Registered!");
    }

    static void viewComplaints(int studentId) {
        FindIterable<Document> list = complaints.find(eq("studentId", studentId));

        for (Document d : list) {
            System.out.println(d.toJson());
        }
    }

    static void bookResource(int studentId) {
        sc.nextLine();

        System.out.print("Enter Resource: ");
        String resource = sc.nextLine();

        System.out.print("Enter Time Slot: ");
        String slot = sc.nextLine();

        System.out.print("Enter Date: ");
        String date = sc.nextLine();

        Document existing = bookings.find(and(
                eq("resource", resource),
                eq("timeSlot", slot),
                eq("date", date)
        )).first();

        if (existing != null) {
            System.out.println("Slot already booked!");
            return;
        }

        bookings.insertOne(new Document("resource", resource)
                .append("studentId", studentId)
                .append("timeSlot", slot)
                .append("date", date));

        System.out.println("Booking Successful!");
    }

    static void cancelBooking(int studentId) {
        sc.nextLine();

        System.out.print("Enter Resource: ");
        String resource = sc.nextLine();

        bookings.deleteOne(and(eq("studentId", studentId), eq("resource", resource)));

        System.out.println("Booking Cancelled!");
    }

    // ================= ADMIN =================

    static void adminMenu() {
        while (true) {
            System.out.println("\n1. View Complaints\n2. Update Complaint Status\n3. View Bookings\n4. Logout");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    viewAllComplaints();
                    break;
                case 2:
                    updateStatus();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    return;
            }
        }
    }

    static void viewAllComplaints() {
        for (Document d : complaints.find()) {
            System.out.println(d.toJson());
        }
    }

    static void updateStatus() {
        sc.nextLine();

        System.out.print("Enter Description to update: ");
        String desc = sc.nextLine();

        System.out.print("Enter New Status: ");
        String status = sc.nextLine();

        complaints.updateOne(eq("description", desc),
                new Document("$set", new Document("status", status)));

        System.out.println("Updated!");
    }

    static void viewBookings() {
        for (Document d : bookings.find()) {
            System.out.println(d.toJson());
        }
    }
}