package dao;

import adaptors.ParticipantAdaptor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import model.Participant;

public class ParticipantDao implements Dao<DBCollection,Participant> {

    DBCollection collection;

    public ParticipantDao(DBCollection collection) {
        this.collection = collection;
    }

    public void create(Participant participant) {
        collection.insert(ParticipantAdaptor.toDBObject(participant));
    }

    public DBObject retrieve(String id) {
        BasicDBObject _id = new BasicDBObject();
        DBCursor cursor = collection.find(_id);
        _id.put("_id", id);

        return cursor.next();
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
