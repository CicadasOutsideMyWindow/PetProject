package model;

import java.util.Date;
import java.util.List;

public class Event {

    private String id;
    private Date startDate;
    private Date endDate;
    private String title;
    private Date timestamp;
    private String location;
    private String description;
    private List<Participant> participants;
    private List<Participant> waitlist;
    private Participant eventHost;


    public Event(String id, Date startDate, Date endDate, String title, Date timestamp, String location, List<Participant> participants) {
        this.id = id;
        this.startDate = startDate;
        this.startDate = endDate;
        this.title = title;
        this.timestamp = timestamp;
        this.location = location;
        this.participants = participants;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDateDate(Date date) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public List<Participant> getWaitlist() {
        return waitlist;
    }

    public void setWaitlist(List<Participant> waitlist) {
        this.waitlist = waitlist;
    }

    public Participant getEventHost() {
        return eventHost;
    }

    public void setEventHost(Participant eventHost) {
        this.eventHost = eventHost;
    }
}
