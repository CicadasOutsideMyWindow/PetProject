package dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

import model.Participant;
import org.bson.Document;
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

public class ParticipantDao implements Dao<Participant> {

    MongoCollection collection;
    Gson gson;

    public ParticipantDao(MongoCollection collection) {
        this.collection = collection;
        gson = new Gson();
    }

    public Participant create(Participant participant) {
        participant.id = new ObjectId().toHexString();
        Document p = Document.parse(gson.toJson(participant));
        p.put("_id", participant.id);
        collection.insertOne(p);
        return retrieve(participant.id);
    }

    public Participant retrieve(String id) {
        Document p  = (Document) collection.find(eq("_id", id)).first();
        return gson.fromJson(p.toJson(), Participant.class);
    }

    public Participant update(Participant participant) throws Exception {
        Document p = Document.parse(gson.toJson(participant));
        UpdateResult res = collection.replaceOne(Filters.eq("_id", participant.getId()), p);

        if (res.getModifiedCount() > 0) {
            return retrieve(participant.id);
        }
        throw new Exception("Not found");
    }

    public Participant delete(String id) throws Exception {
        Participant p = retrieve(id);
        p.deleted = true;
        return update(p);

    }
}
