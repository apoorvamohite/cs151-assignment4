package edu.sjsu.cs.q1;

public class Main {
    public static void main(String[] args) {
        SWEJobDashboard jobDashboard = new SWEJobDashboard();

        JobSeekerBot bot1 = new JobSeekerBot(jobDashboard, "Bot1");
        JobSeekerBot bot2 = new JobSeekerBot(jobDashboard, "Bot2");
        NewGradJobSeeker newGrad = new NewGradJobSeeker(jobDashboard, "NewGrad");

        JobPosting newJob = new JobPosting("Software Engineer Internship", "San Jose");
        jobDashboard.postJob(newJob);
    }
}









