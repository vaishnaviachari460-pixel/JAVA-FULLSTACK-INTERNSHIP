package mongodemo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.FindIterable;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class LibraryManagement {

    public static void main(String[] args) {

        // 1️⃣ Connect to MongoDB
        MongoClient mongoClient = MongoClients.create("");

        // 2️⃣ Create / Access Database
        MongoDatabase database = mongoClient.getDatabase("libraryDB");

        // 3️⃣ Create / Access Collection
        MongoCollection<Document> collection = database.getCollection("books");

        // -------------------------------
        // INSERT BOOK RECORDS
        // -------------------------------

        Document book1 = new Document("book_id", 101)
                .append("title", "Data Structures")
                .append("author", "Mark Allen")
                .append("genre", "Computer Science")
                .append("status", "Available");

        Document book2 = new Document("book_id", 102)
                .append("title", "Java Programming")
                .append("author", "James Gosling")	
                .append("genre", "Computer Science")
                .append("status", "Available");

        Document book3 = new Document("book_id", 103)
                .append("title", "English Grammar")
                .append("author", "Wren Martin")
                .append("genre", "Education")
                .append("status", "Available");

        collection.insertOne(book1);
        collection.insertOne(book2);
        collection.insertOne(book3);

        System.out.println("Books inserted successfully");

        // -------------------------------
        // DISPLAY ALL BOOKS
        // -------------------------------

        System.out.println("\nAll Books:");

        FindIterable<Document> books = collection.find();

        for (Document doc : books) {
            System.out.println(doc.toJson());
        }

        // -------------------------------
        // FIND BOOKS BY GENRE
        // -------------------------------

        System.out.println("\nComputer Science Books:");

        FindIterable<Document> csBooks = collection.find(eq("genre", "Computer Science"));

        for (Document doc : csBooks) {
            System.out.println(doc.toJson());
        }

        // -------------------------------
        // UPDATE BOOK STATUS
        // -------------------------------

        collection.updateOne(eq("book_id", 101), set("status", "Issued"));

        System.out.println("\nBook status updated successfully");

        // -------------------------------
        // DELETE BOOK
        // -------------------------------

        collection.deleteOne(eq("book_id", 103));

        System.out.println("\nBook deleted successfully");

        // Close connection
        mongoClient.close();
    }
}