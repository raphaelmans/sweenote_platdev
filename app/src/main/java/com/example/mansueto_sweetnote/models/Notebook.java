package com.example.mansueto_sweetnote.models;

public class Notebook {

    private String notebookName;
    private String courseTitle;
    private String courseCode;
    private String instructor;
    private int priority;
    private String schedule;
    private String schoolSemYear;

    public Notebook() {

    }
    public Notebook(String notebookName,
             String courseTitle,
             String courseCode,
             String instructor,
             int priority,
             String schedule,
             String schoolSemYear){
        this.notebookName = notebookName;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.instructor = instructor;
        this.priority = priority;
        this.schedule = schedule;
        this.schoolSemYear = schoolSemYear;
    }

    public String getNotebookName() {
        return notebookName;
    }

    public void setNotebookName(String notebookName) {
        this.notebookName = notebookName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getSchoolSemYear() {
        return schoolSemYear;
    }

    public void setSchoolSemYear(String schoolSemYear) {
        this.schoolSemYear = schoolSemYear;
    }
}
