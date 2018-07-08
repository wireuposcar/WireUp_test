package com.wireupfinland.wireup_test.Services;

public class DataService {
    public String subject;
    public String projectName;
    public String endDate;
    public String people;
    public String userid;

    public DataService() {
    }

    public DataService(String subject, String projectName, String endDate, String people, String userid) {
        this.subject = subject;
        this.projectName = projectName;
        this.endDate = endDate;
        this.people = people;
        this.userid = userid;
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

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
