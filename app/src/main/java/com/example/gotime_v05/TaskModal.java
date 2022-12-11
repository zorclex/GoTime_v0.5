package com.example.gotime_v05;

public class TaskModal {

    // variables for our course name,
    // description, tracks and duration, id.
    private String courseName;
    private String courseTracks;
    private String courseDescription;
    private int id;

    // creating getter and setter methods
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public String getCourseTracks() {
        return courseTracks;
    }

    public void setCourseTracks(String courseTracks) {
        this.courseTracks = courseTracks;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public TaskModal(String courseName, String courseTracks, String courseDescription) {
        this.courseName = courseName;

        this.courseTracks = courseTracks;
        this.courseDescription = courseDescription;
    }
}
