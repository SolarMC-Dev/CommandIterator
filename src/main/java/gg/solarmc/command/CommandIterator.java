package gg.solarmc.command;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over command arguments. Arguments may be consumed and processed
 * as the iterator advances. It is also possible to {@code peek} on the next argument.
 *
 */
public interface CommandIterator extends Iterator<String> {

    /**
     * Takes a look at the next argument without consuming it
     *
     * @return the next argument
     * @throws NoSuchElementException if there is no argument next
     */
    String peek();

    /**
     * Concatenates all remaining arguments into a single string,
     * as they were in their original input. Consumes the rest of this iterator. <br>
     * <br>
     * This is usually the same as processing the arguments in a loop and
     * joining them with spaces.
     *
     * @return all the remaining arguments concatenated, or an empty string if no arguments remain
     */
    String concatRemaining();

    /**
     * Implementations are encouraged to yield a useful toString
     *
     * @return the string representation
     */
    @Override
    String toString();
}
