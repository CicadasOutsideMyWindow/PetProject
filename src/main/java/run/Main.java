package run;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import dao.ParticipantDao;
import model.Participant;
import model.ParticipantRole;

public class Main {


    public static void main (String[] args) {

        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("ThePetProjectDB");
        MongoCollection participantsCollection = db.getCollection("Participants");

        ParticipantDao pd = new ParticipantDao(participantsCollection);

        // Create and get a database:

        Participant participant = new Participant("Uwechuckwu Uwakwe", ParticipantRole.PARTICIPANT, "a@e.com");

        //CRUD:

        participant = pd.create(participant);

//        query.put("_id", "54a5355a4c954d06b9a0a5212d6d83d");
//        updates.put("email", "whatever@gmail.com");
//        pd.update(collection, query, updates);
//
        try {
            participant = pd.delete(participant.getId());
            System.out.println(new Gson().toJson(participant));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
