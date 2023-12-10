package edu.sjsu.cs.q1;

public class NewGradJobSeeker implements JobSeeker {
    private String name;
    private JobDashboard jobDashboard;

    public NewGradJobSeeker(JobDashboard jobDashboard, String name) {
        this.jobDashboard = jobDashboard;
        this.name = name;
        jobDashboard.registerObserver(this);
    }

    @Override
    public void update(JobPosting jobPosting) {
        System.out.println(name + " received notification: " + jobPosting);
        if (jobPosting.getTitle().toLowerCase().contains("entry level") &&
                jobPosting.getLocation().equalsIgnoreCase("anywhere")) {
            System.out.println(name + " is applying for the job!");
        }
    }
}
