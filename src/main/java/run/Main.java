package run;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import dao.ParticipantDao;
import model.Participant;

public class Main {

    static MongoClient mongoClient = null;
    static ParticipantDao pd = new ParticipantDao();
    static BasicDBObject query = new BasicDBObject();
    static BasicDBObject updates = new BasicDBObject();

    public static void main (String[] args) {

        try {
            mongoClient = new MongoClient();
        } catch (java.net.UnknownHostException e) {
            e.printStackTrace();
        }

        // Create and get a database:

        DB database = mongoClient.getDB("ThePetProjectDB");
        DBCollection collection = database.getCollection("Participants");

        Participant participant = new Participant("54a5355a4c954d06b9a0a5212d6d83d", "Uwechuckwu Uwakwe", "participant", "a@e.com");

        //CRUD:

        pd.create(collection, participant);

        query.put("_id", "54a5355a4c954d06b9a0a5212d6d83d");
        updates.put("email", "whatever@gmail.com");
        pd.update(collection, query, updates);

        pd.delete(collection, participant);

    }

}
