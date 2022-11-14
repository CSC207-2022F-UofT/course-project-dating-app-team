package database_connection;

import java.util.UUID;
import java.time.Instant;

import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.types.ObjectId;


import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import java.util.List;
import java.util.ArrayList;

import java.util.Arrays;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Sorts.descending;

public class database_usage_example {

    public static void main(String[] args) {
        // paste in connection string
        Database myDatabase = new Database("<connection string goes here>", "DatingAppStaging");

        //test for insert_post
        myDatabase.insert_post("input_username", "input_post_content");

        //test for insert_reply
        myDatabase.insert_reply("_id","input_username", "input_reply_content");

        //test for find_post_by_id
        Document doc1 = myDatabase.find_post_by_id("_id");
        System.out.println(doc1);

        //test for find_latest_posts
        List<Document> doc2 = myDatabase.find_latest_posts(1);
        System.out.println(doc2);
    }
}
// <connection string goes here>