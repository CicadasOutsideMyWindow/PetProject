package dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import model.Participant;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

public class ParticipantDao implements Dao<Participant> {

    MongoCollection collection;

    public ParticipantDao(MongoCollection collection) {
        this.collection = collection;
    }

    public Document create(Participant participant) {

        Gson gson = new Gson();
        Document p = Document.parse(gson.toJson(participant));

        collection.insertOne(p);

        return p;
    }

    public Document retrieve(String id) {

        Document p  = (Document) collection.find(eq("_id", id)).first();

        return p;
    }

    public Document update(Participant participant) {

        Gson gson = new Gson();
        Document p = Document.parse(gson.toJson(participant));

        collection.replaceOne(Filters.eq("_id", participant.getId()), p);

        return p;

    }

    public Document delete(String id) {

        Gson gson = new Gson();

        Document p = retrieve(id);

        Participant participant = gson.fromJson(gson.toJson(p), Participant.class);
        participant.setDeleted();

        update(participant);

        p = Document.parse(gson.toJson(participant));

        return p;

    }
}
