package edu.sjsu.cs.q1;

import java.util.ArrayList;
import java.util.List;

public class SWEJobDashboard implements JobDashboard {
    private List<JobSeeker> observers = new ArrayList<>();

    @Override
    public void registerObserver(JobSeeker observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(JobSeeker observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(JobPosting jobPosting) {
        for (JobSeeker observer : observers) {
            observer.update(jobPosting);
        }
    }

    public void postJob(JobPosting jobPosting) {
        System.out.println("Job Posted: " + jobPosting);
        notifyObservers(jobPosting);
    }
}