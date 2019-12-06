package dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;
import model.Participant;
import model.ParticipantRole;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class ParticipantDao implements Dao<Participant> {

    MongoCollection collection;
    Gson gson;

    public ParticipantDao(MongoCollection collection) {
        this.collection = collection;
        gson = new Gson();
    }

    public Participant create(Participant participant) {

        String id = new ObjectId().toHexString();
        participant.setId(id);

        Document p = Document.parse(gson.toJson(participant));

        p.put("_id", participant.getId());
//        p.put("name", participant.setName());
        p.put("role", participant.setRole(ParticipantRole.PARTICIPANT));
        p.put("createdOn", participant.setCreatedOn());
        p.put("isBanned", participant.setIsBanned(false));
        p.put("isDeleted", participant.setIsDeleted(false));
        collection.insertOne(p);

        return retrieve(participant.getId());
    }

    public Participant retrieve(String id) {

        Document p  = (Document) collection.find(eq("_id", id)).first();

        return gson.fromJson(p.toJson(), Participant.class);
    }

    public Participant update(String id, Participant participant) throws Exception{

        Document p = Document.parse(gson.toJson(participant));
        UpdateResult result = collection.replaceOne(Filters.eq("_id", id), p);

        if (result.getModifiedCount() > 0) {
            return retrieve(id);
        }
        throw new Exception("Participant Not Fount");
    }

    public Participant delete(String id) throws Exception {

        Participant p = retrieve(id);
        p.setDeleted();

        return update(id, p);

    }

    public List<Document> getAllParticipants() {
//TODO: return JSON including additional info (at least a total count of documetns)
//        {
//            "limit":1,
//            "offset":0,
//            "count":10,
//            "order":{
//                  "by":"Name",
//                  "direction":"asc"
//             },
//            "items": []
//        }

        MongoCursor<Document> cursor = collection.find().iterator();
        List<Document> documentList = new ArrayList<Document>();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                documentList.add(doc);
            }
        } finally {
            cursor.close();
        }
    return documentList;
    }
}
