package gg.solarmc.command;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayCommandIteratorTest {

    @Test
    public void noArguments1() {
        CommandIterator command = new ArrayCommandIterator();
        assertThrows(NoSuchElementException.class, command::next);
        assertThrows(NoSuchElementException.class, command::peek);
    }

    @Test
    public void noArguments2() {
        CommandIterator command = new ArrayCommandIterator();
        assertFalse(command.hasNext());
        assertThrows(NoSuchElementException.class, command::next);
        assertThrows(NoSuchElementException.class, command::peek);
    }

    @Test
    public void oneArgument1() {
        CommandIterator command = new ArrayCommandIterator("arg");
        assertTrue(command.hasNext());
        assertEquals("arg", command.next());
        assertFalse(command.hasNext());
        assertThrows(NoSuchElementException.class, command::next);
    }

    @Test
    public void oneArgument2() {
        CommandIterator command = new ArrayCommandIterator("arg");
        assertTrue(command.hasNext());
        assertEquals("arg", command.next());
        assertThrows(NoSuchElementException.class, command::peek);
    }

    @Test
    public void multipleArguments() {
        CommandIterator command = new ArrayCommandIterator("arg1", "arg2", "arg3");
        assertTrue(command.hasNext());
        assertEquals("arg1", command.next());
        assertEquals("arg2", command.peek());
        assertEquals("arg2", command.next());
        assertEquals("arg3", command.next());
    }

    @Test
    public void concatRemaining1() {
        CommandIterator command = new ArrayCommandIterator("arg1", "arg2", "arg3");
        assertTrue(command.hasNext());
        assertEquals("arg1 arg2 arg3", command.concatRemaining());
    }

    @Test
    public void concatRemaining2() {
        CommandIterator command = new ArrayCommandIterator("arg1", "arg2", "arg3");
        assertTrue(command.hasNext());
        assertEquals("arg1", command.next());
        assertEquals("arg2 arg3", command.concatRemaining());
    }

}
