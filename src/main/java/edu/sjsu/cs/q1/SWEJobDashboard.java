package edu.sjsu.cs.q1;

import java.util.ArrayList;
import java.util.List;

public class SWEJobDashboard implements JobDashboard {
    private List<JobSeeker> observers = new ArrayList<>();

    @Override
    public void registerObserver(JobSeeker observer) {
        if(observer == null) {
            throw new RuntimeException("Observer cannot be null");
        }
        if(observers.contains(observer)) {
            throw new RuntimeException("Already Observing");
        }
        observers.add(observer);
    }

    @Override
    public void removeObserver(JobSeeker observer) {
        if(observer == null) {
            throw new RuntimeException("Observer cannot be null");
        }
        if(!observers.contains(observer)) {
            throw new RuntimeException("Observer not found");
        }
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(JobPosting jobPosting) {
        for (JobSeeker observer : observers) {
            observer.update(jobPosting);
        }
    }

    public void postJob(JobPosting jobPosting) {
        if(jobPosting == null) {
            throw new RuntimeException("JobPosting cannot be null");
        }
        System.out.println("Job Posted: " + jobPosting);
        notifyObservers(jobPosting);
    }
}