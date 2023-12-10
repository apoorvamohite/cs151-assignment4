package edu.sjsu.cs.q1;

public interface JobDashboard {
    void registerObserver(JobSeeker observer);
    void removeObserver(JobSeeker observer);
    void notifyObservers(JobPosting jobPosting);
}
