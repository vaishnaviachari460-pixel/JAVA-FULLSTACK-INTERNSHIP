package mongodemo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class app {

    public static void main(String[] args) {

        String uri = "";

        try (MongoClient mongoClient = MongoClients.create(uri)) {

            MongoDatabase database = mongoClient.getDatabase("studentDB");

            System.out.println("Connected to MongoDB Atlas Cluster successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
		
    }
}