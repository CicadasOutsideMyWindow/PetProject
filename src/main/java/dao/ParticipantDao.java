package dao;

import adaptors.ParticipantAdaptor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import model.Participant;

public class ParticipantDao implements Dao<DBCollection,Participant> {

    DBCollection collection;

    public ParticipantDao(DBCollection collection) {
        this.collection = collection;
    }

    public void create(Participant participant) {
        collection.insert(ParticipantAdaptor.toDBObject(participant));
    }

    public void update(BasicDBObject query, BasicDBObject updates) {
        BasicDBObject u = new BasicDBObject();
        u.put("$set", updates);
        collection.update(query, u);
    }

    public void delete(Participant participant) {
        collection.remove(ParticipantAdaptor.toDBObject(participant));
    }
}
