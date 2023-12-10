package q3;

import edu.sjsu.cs.q1.JobPosting;
import edu.sjsu.cs.q1.JobSeekerBot;
import edu.sjsu.cs.q1.NewGradJobSeeker;
import edu.sjsu.cs.q1.SWEJobDashboard;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class Q1Test {
    private SWEJobDashboard jobDashboard;
    private JobSeekerBot bot;
    private NewGradJobSeeker newGrad;

    @Before
    public void setUp() {
        jobDashboard = new SWEJobDashboard();
    }

    @Test
    public void testJobSeekerBotApplication() {
        bot = new JobSeekerBot(jobDashboard, "Bot");
        JobPosting job = new JobPosting("Software Engineer Internship", "Specific Location");
        String output = TestUtils.getConsoleOutput(() -> jobDashboard.postJob(job));
        assertTrue(output.contains("Job Posted: JobPosting{title='Software Engineer Internship', location='Specific Location'}"));
        assertTrue(output.contains("Bot received notification: JobPosting{title='Software Engineer Internship', location='Specific Location'}"));
        assertTrue(output.contains("Bot is applying for the job!"));
    }

    @Test(expected = RuntimeException.class)
    public void testJobSeekerBotApplicationNegative() {
        bot = new JobSeekerBot(null, "Bot");
    }

    @Test
    public void testNewGradJobSeekerApplication() {
        newGrad = new NewGradJobSeeker(jobDashboard, "NewGrad");
        JobPosting job = new JobPosting("Entry Level Developer", "Anywhere");
        String output = TestUtils.getConsoleOutput(() -> jobDashboard.postJob(job));
        assertTrue(output.contains("Job Posted: JobPosting{title='Entry Level Developer', location='Anywhere'}"));
        assertTrue(output.contains("NewGrad received notification: JobPosting{title='Entry Level Developer', location='Anywhere'}"));
        assertTrue(output.contains("NewGrad is applying for the job!"));
    }

    @Test(expected = RuntimeException.class)
    public void testNewGradJobSeekerApplicationNegative() {
        newGrad = new NewGradJobSeeker(null, "NewGrad");
    }

    @Test(expected = RuntimeException.class)
    public void testPostJobNegative() {
        jobDashboard.postJob(null);
    }

    @Test(expected = RuntimeException.class)
    public void testRegisterObserverNegative() {
        bot = new JobSeekerBot(jobDashboard, "Bot");
        jobDashboard.registerObserver(bot);
    }

    @Test(expected = RuntimeException.class)
    public void testRegisterObserverNegativeWithNull() {
        jobDashboard.registerObserver(null);
    }

    @Test()
    public void testRemoveObserver() {
        bot = new JobSeekerBot(jobDashboard, "Bot");
        jobDashboard.removeObserver(bot);
        boolean exception = false;
        try {
            jobDashboard.removeObserver(bot);
        } catch (Exception ex) {
            exception = true;
        }
        assertTrue(exception);
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveObserverNegative() {
        bot = new JobSeekerBot(jobDashboard, "Bot");
        jobDashboard.removeObserver(bot);
        jobDashboard.removeObserver(bot);
    }

    @Test(expected = RuntimeException.class)
    public void testRemoveObserverNegativeWithNull() {
        jobDashboard.removeObserver(null);
    }

}
