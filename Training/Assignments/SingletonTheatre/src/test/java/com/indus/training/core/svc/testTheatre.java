package com.indus.training.core.svc;

import com.indus.training.core.impl.Theatre;

import junit.framework.TestCase;

public class testTheatre extends TestCase {

    public void testBookSeat() {
        Theatre theatre = Theatre.getMovieTheatreInstance(3);


        // Expected output
        boolean[] expectedOutputs = { true, true, true, false };
        
        // Actual output
        boolean[] actualOutputs = new boolean[4];
        actualOutputs[0] = theatre.bookSeat();
        actualOutputs[1] = theatre.bookSeat();
        actualOutputs[2] = theatre.bookSeat();
        actualOutputs[3] = theatre.bookSeat();
        System.out.println(theatre.getRemSeats());

        // Assertions
        for (int i = 0; i < expectedOutputs.length; i++) {
            assertEquals(expectedOutputs[i], actualOutputs[i]);
        }
        
        // Verify remaining seats
        assertEquals(0, theatre.getRemSeats());
    }
}
