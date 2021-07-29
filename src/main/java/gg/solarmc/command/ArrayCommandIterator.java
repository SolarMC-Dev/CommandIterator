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
