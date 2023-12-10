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

    @Test
    public void testNewGradJobSeekerApplication() {
        newGrad = new NewGradJobSeeker(jobDashboard, "NewGrad");
        JobPosting job = new JobPosting("Entry Level Developer", "Anywhere");
        String output = TestUtils.getConsoleOutput(() -> jobDashboard.postJob(job));
        assertTrue(output.contains("Job Posted: JobPosting{title='Entry Level Developer', location='Anywhere'}"));
        assertTrue(output.contains("NewGrad received notification: JobPosting{title='Entry Level Developer', location='Anywhere'}"));
        assertTrue(output.contains("NewGrad is applying for the job!"));
    }
}
