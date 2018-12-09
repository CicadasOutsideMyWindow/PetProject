package model;

import java.util.Date;

public class Participant {

    public String id;
    public String name;
    public ParticipantRole role;
    public Date dob;
    public String email;
    public boolean banned;
    public boolean deleted;
    public double attendance;


    public Participant(String name, ParticipantRole role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public Participant(String id, String name, ParticipantRole role, String email, Date dob, boolean banned, double attendance) {
        super();
        this.dob = dob;
        this.banned = banned;
        this.attendance = attendance;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
