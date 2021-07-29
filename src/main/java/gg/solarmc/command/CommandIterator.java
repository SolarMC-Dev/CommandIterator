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
