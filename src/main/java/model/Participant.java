package model;

import java.util.Date;

public class Participant {

    private String _id;
    private String name;
    private ParticipantRole role;
    private Date dob;
    private String email;
    private boolean banned;
    private double attendance;
//    private int noShows;
    private int late;
    private boolean isDeleted;

    //TODO: add date joined to the group;
    //      add date joined to an event;
    //      add total games attended;


    public Participant(String name, ParticipantRole role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setDeleted() {
        this.isDeleted = true;
    }

    public void setUndeleted() {
        this.isDeleted = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted(){
        return isDeleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantRole getRole() {
        return role;
    }

    public void ParticipantRole(ParticipantRole role) {
        this.role = role;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }
}
