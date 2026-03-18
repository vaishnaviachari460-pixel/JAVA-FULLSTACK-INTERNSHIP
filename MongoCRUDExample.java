package mongodemo;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.set;

public class MongoCRUDExample {

    public static void main(String[] args) {

        
        String uri = "";

        
        MongoClient mongoClient = MongoClients.create(uri);

        
        MongoDatabase database = mongoClient.getDatabase("studentDB");

        
        MongoCollection<Document> collection = database.getCollection("students");

        
        Document student = new Document("name", "Rahul")
                .append("age", 22)
                .append("course", "Python Fullstack");

        collection.insertOne(student);
        System.out.println("Student inserted");

        
        System.out.println("\nStudents List:");
        for (Document doc : collection.find()) {
            System.out.println(doc.toJson());
        }

        
        collection.updateOne(eq("name", "Rahul"),
                set("course", "Java Fullstack"));

        System.out.println("\nStudent updated");

       
        collection.deleteOne(eq("name", "Rahul"));

        System.out.println("\nStudent deleted");

        
        mongoClient.close();
    }
}