package model;

import java.awt.*;
import java.util.List;

public class Venue {

    private String id;
    private String venueName;
    private String address;
    private String surfaceType;
    private String dimensions;
    private List<Image> photos;

    public Venue(String _id) {
        this.id = _id;
    }

    public String getId() {
        return id;
    }

    public void set_id(String _id) {
        this.id = _id;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSurfaceType() {
        return surfaceType;
    }

    public void setSurfaceType(String surfaceType) {
        this.surfaceType = surfaceType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public List<Image> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Image> photos) {
        this.photos = photos;
    }
}
