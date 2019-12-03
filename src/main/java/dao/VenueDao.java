package dao;

import adaptors.VenueAdaptor;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import model.Venue;

public class VenueDao {

    DBCollection collection;

    public VenueDao(DBCollection collection) {
            this.collection = collection;
        }

        public void create(Venue venue) {
            collection.insert(VenueAdaptor.toDBObject(venue));
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
