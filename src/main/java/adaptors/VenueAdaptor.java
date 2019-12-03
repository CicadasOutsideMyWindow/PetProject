package adaptors;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import model.Venue;

public class VenueAdaptor {

    /*
     *
     *    private String _id;
    private String venueName;
    private String address;
    private String surfaceType;
    private String dimensions;
    private List<Image> photos;
     */

    public static final DBObject toDBObject( Venue venue) {
        return new BasicDBObject(
                "_id", venue.getId())
                .append("venueName", venue.getVenueName())
                .append("address", venue.getAddress())
                .append("surfaceType", venue.getSurfaceType())
                .append("dimensions", venue.getDimensions())
                .append("photos", venue.getPhotos());
    }

}
