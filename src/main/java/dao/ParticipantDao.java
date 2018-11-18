package dao;

import adaptors.ParticipantAdaptor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import model.Participant;

public class ParticipantDao implements Dao<DBCollection,Participant> {

    public void create(DBCollection collection, Participant participant) {
        collection.insert(ParticipantAdaptor.toDBObject(participant));
    }

    public void update(DBCollection collection, BasicDBObject query, BasicDBObject updates) {
        BasicDBObject u = new BasicDBObject();
        u.put("$set", updates);
        collection.update(query, u);
    }

    public void delete(DBCollection collection, Participant participant) {
        collection.remove(ParticipantAdaptor.toDBObject(participant));
    }
}
