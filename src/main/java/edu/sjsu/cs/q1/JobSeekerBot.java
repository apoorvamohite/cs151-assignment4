package edu.sjsu.cs.q1;

public class JobSeekerBot implements JobSeeker {
    private String name;
    private JobDashboard jobDashboard;

    public JobSeekerBot(JobDashboard jobDashboard, String name) {
        this.name = name;
        this.jobDashboard = jobDashboard;
        jobDashboard.registerObserver(this);
    }

    @Override
    public void update(JobPosting jobPosting) {
        System.out.println(name + " received notification: " + jobPosting);
        if (jobPosting.getTitle().toLowerCase().contains("internship") &&
                jobPosting.getLocation().equalsIgnoreCase("specific location")) {
            System.out.println(name + " is applying for the job!");
        }
    }
}
