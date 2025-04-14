package com.model;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for the Instrument class.
 * @author Rondasha
 */
public class InstrumentTest {
    private Instrument instrument;

    @Before
    void setUp() {
        instrument = new Instrument("Guitar", "Wonderwall", 120, 85.5);
    }

    @Test
    void testPlayExercise() {
        assertEquals("Guitar is playing Wonderwall at 120 BPM.", instrument.playExercise());
    }

    @Test
    void testEvaluatePerformance() {
        assertEquals("Performance evaluated. New accuracy score: 95.0", instrument.evaluatePerformance(95.0));
        assertEquals(95.0, instrument.getAccuracyScore(), 0.01);
    }
}
