package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class NoteTest {
    @Test
    public void testTesting()
    {
        assertTrue(true);
    }

   @Test
   public void testGetPitch()
   {
     Note note= new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
     assertEquals("C", note.getPitch());
   }
}

