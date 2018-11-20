package dao;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;
import model.Participant;

public class ParticipantDao implements Dao<DBCollection,Participant> {

    DBCollection collection;

    public ParticipantDao(DBCollection collection) {
        this.collection = collection;
    }

    public void create(Participant participant) {

        Gson gson = new Gson();
        String json = gson.toJson(participant);
        DBObject participantDBObject = (DBObject) JSON.parse(json);

        collection.insert(participantDBObject);
    }

    public DBObject retrieve(String id) {
        BasicDBObject _id = new BasicDBObject();

        DBObject participant = collection.findOne(_id);
        _id.put("_id", id);

        return participant;
    }

    public void update(BasicDBObject query, BasicDBObject updates) {
        BasicDBObject u = new BasicDBObject();
        u.put("$set", updates);
        collection.update(query, u);
    }

    public void delete(String id) {
        BasicDBObject _id = new BasicDBObject();
        _id.put("_id", id);
        collection.remove(_id);
    }
}
