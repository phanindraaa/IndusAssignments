package com.indus.training.core.svc;

import junit.framework.TestCase;
import com.indus.training.core.impl.Movie;

public class testEntertainment extends TestCase {
    
    private Movie movie;

    protected void setUp() throws Exception {
        super.setUp();
        movie = new Movie();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        movie = null;
    }

    public void testMovieDetailsScenario() {
        // 1) Input
        String title = "Inception";
        double duration = 2.5;

        // 2) Expected Output
        String expOutput = "Movie Title: " + title + ", Duration: " + duration + " hours";

        // 3) Actual Output
        String actOutput = movie.getDetails(title, duration);

        // 4) Assertions
        assertEquals(expOutput, actOutput);
    }

    public void testMoviePlayScenario() {
        // Expected Output
        String expOutput = "Playing movie";

        // Actual Output
        String actOutput = movie.play();

        // Assertions
        assertEquals(expOutput, actOutput);
    }
}
