package model;

import java.util.Date;

public class Participant {

    private String _id;
    private String name;
    private ParticipantRole role;
    private Date dob;
    private String email;
    private boolean isBanned;
    private double attendance;
//    private int noShows;
    private int late;
    private boolean isDeleted;
    private Date createdOn;

    //TODO: add date joined to the group;
    //      add date joined to an event;
    //      add total games attended;


    public Participant(String name, ParticipantRole role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public Participant(String name, String email) {
        this.name = name;
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

    public boolean setIsDeleted(boolean isDeleted){
        return isDeleted;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParticipantRole getRole() {
        return role;
    }

    public String setRole(ParticipantRole role) {
        this.role = role;
        return role.toString();
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
        return isBanned;
    }

    public boolean setIsBanned(boolean isBanned) {
        return isBanned;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

//    public Date getAccountCreated() {
//        return accountCreated;
//    }

    public Date getCreatedOn() {
        return createdOn;
    }

//    public void setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//    }

    public Date setCreatedOn() {
        Date date = new Date();
        return date;
    }
}
