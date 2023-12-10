package edu.sjsu.cs.q1;

public class JobPosting {
    private String title;
    private String location;

    public JobPosting(String title, String location) {
        this.title = title;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "JobPosting{" +
                "title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
