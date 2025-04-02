package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class NoteTest{
    @Test
    public void testTesting()
    {
        assertTrue(true);
    }

   @Test
   public void testGetPitch_validPitch()
   {
     Note note= new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
     assertEquals("C", note.getPitch());
   }

   @Test 
   public void getPitch_emptyPitch() {
    Note note = new Note("", "", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
    assertEquals("", note.getPitch());
    }
    @Test
    public void getPitch_specialCharacterPitch() {
        Note note = new Note("", "C#", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertEquals("C#", note.getPitch());
    }

    @Test
    public void getPitch_differentPitch() {
        Note note = new Note("", "D", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertEquals("D", note.getPitch());
    }

    @Test
    public void getPitch_lowerCasePitch() {
        Note note = new Note("", "c", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertEquals("c", note.getPitch());
    }

     @Test
    public void setPitch_validPitch() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setPitch("D"));
        assertEquals("D", note.getPitch());
    }

    @Test
    public void setPitch_nullPitch() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertFalse(note.setPitch(null));
        assertEquals("C", note.getPitch());
    }

    @Test
    public void setPitch_emptyPitch() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertFalse(note.setPitch(""));
        assertEquals("C", note.getPitch());
    }

    @Test
    public void setPitch_specialCharacterPitch() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setPitch("C#"));
        assertEquals("C#", note.getPitch());
    }

    @Test
    public void setPitch_differentPitch() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setPitch("E"));
        assertEquals("E", note.getPitch());
    }

    @Test
    public void setModifier_validModifier() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setModifier("#"));
        assertEquals("#", note.getModifier());
    }

    @Test
    public void setModifier_nullModifier() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertFalse(note.setModifier(null));
        assertEquals("", note.getModifier());
    }

    @Test
    public void setModifier_emptyModifier() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setModifier(""));
        assertEquals("", note.getModifier());
    }

    @Test
    public void setModifier_specialCharacterModifier() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setModifier("b"));
        assertEquals("b", note.getModifier());
    }

    @Test
    public void setModifier_differentModifier() {
        Note note = new Note("", "C", Notetype.QUARTER_NOTE, false, "", 4, "4/4");
        assertTrue(note.setModifier("#"));
        assertEquals("#", note.getModifier());
    }

    @Test
    public void toJFugueString_validNote() {
        Note note = new Note("#", "C", Notetype.QUARTER_NOTE, false, "Staccato", 4, "4/4");
        assertEquals("C#4qStaccato", note.toJFugueString());
    }

    @Test
    public void toJFugueString_noModifierOrArticulation() {
        Note note = new Note("", "D", Notetype.HALF_NOTE, false, "", 5, "4/4");
        assertEquals("D5h", note.toJFugueString());
    }

    @Test
    public void toJFugueString_tiedNote() {
        Note note = new Note("", "E", Notetype.EIGHTH_NOTE, true, "", 3, "4/4");
        assertEquals("E3i_", note.toJFugueString());
    }

    @Test
    public void toJFugueString_restNote() {
        Note note = new Note("", "R", Notetype.WHOLE_REST, false, "", 4, "4/4");
        assertEquals("Rw", note.toJFugueString());
    }

    @Test
    public void toJFugueString_differentNoteType() {
        Note note = new Note("", "A", Notetype.SIXTEENTH_NOTE, false, "", 2, "4/4");
        assertEquals("A2s", note.toJFugueString());
    }



}

