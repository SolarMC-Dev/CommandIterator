/*
 * CommandIterator
 * Copyright © 2021 SolarMC Developers
 *
 * CommandIterator is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CommandIterator is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with CommandIterator. If not, see <https://www.gnu.org/licenses/>
 * and navigate to version 3 of the GNU Lesser General Public License.
 */

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
