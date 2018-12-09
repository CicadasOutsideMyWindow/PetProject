package adaptors;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.Event;

public class VenueAdaptor {

    public static final DBObject toDBObject(Event event) {
        return new BasicDBObject(
                "_id", event.getId())
                .append("eventName", event.getTitle())
                .append("startDate", event.getStartDate())
                .append("duration", event.getDuration())
                .append("location", event.getLocation())
                .append("description", event.getDescription())
                .append("participants", event.getParticipants())
                .append("waitlist", event.getWaitlist())
                .append("eventHost", event.getEventHost());
    }

}
