package com.wireupfinland.wireup_test.Services;

public class DataService {
    public String subject;
    public String projectName;
    public String endDate;
    public String members;
    public String userid;
    public String creationDate;
    public String dropbox;
    public String evernote;
    public String googleDocs;

    public DataService() {
    }

    public DataService(String subject, String projectName, String endDate, String members, String userid, String creationDate, String dropbox, String evernote, String googleDocs) {
        this.subject = subject;
        this.projectName = projectName;
        this.endDate = endDate;
        this.members = members;
        this.userid = userid;
        this.creationDate = creationDate;
        this.dropbox = dropbox;
        this.evernote = evernote;
        this.googleDocs = googleDocs;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getDropbox() {
        return dropbox;
    }

    public void setDropbox(String dropbox) {
        this.dropbox = dropbox;
    }

    public String getEvernote() {
        return evernote;
    }

    public void setEvernote(String evernote) {
        this.evernote = evernote;
    }

    public String getGoogleDocs() {
        return googleDocs;
    }

    public void setGoogleDocs(String googleDocs) {
        this.googleDocs = googleDocs;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getmembers() {
        return members;
    }

    public void setmembers(String members) {
        this.members = members;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
