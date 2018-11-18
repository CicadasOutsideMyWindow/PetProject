package adaptors;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.Participant;

public class ParticipantAdaptor {

    public static final DBObject toDBObject(Participant participant) {
        return new BasicDBObject("_id", participant.getId())
                .append("name", participant.getName())
                .append("role", participant.getRole())
                .append("email", participant.getEmail());

    }
}
