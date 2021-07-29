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

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Implementation of command iterator based on an argument array.
 *
 */
public final class ArrayCommandIterator implements CommandIterator {

    private final String[] content;
    private int position;

    /**
     * Creates from a source array
     *
     * @param content the source arguments, which are copied
     */
    public ArrayCommandIterator(String...content) {
        this.content = content.clone();
    }

    @Override
    public boolean hasNext() {
        return position < content.length;
    }

    @Override
    public String next() {
        String next = peek();
        position++;
        return next;
    }

    @Override
    public String peek() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return content[position];
    }

    @Override
    public String concatRemaining() {
        return String.join(" ", Arrays.asList(content).subList(position, content.length));
    }

    @Override
    public void forEachRemaining(Consumer<? super String> action) {
        try {
            for (int n = position; n < content.length; n++) {
                action.accept(content[n]);
            }
        } finally {
            position = content.length;
        }
    }

    @Override
    public String toString() {
        return "ArrayCommandIterator{" +
                "content=" + Arrays.toString(content) +
                ", position=" + position +
                '}';
    }
}
