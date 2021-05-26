package dev.effective.java.chapter2.item7;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        this.ensureCapacity();
        this.elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object value = this.elements[--size];
        this.elements[size] = null;
        return value;
    }

    public Object pop2() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return this.elements[--size]; // 주목!!
    }

    /**
     * Ensure space for at least one more element, roughly doubling the capacity each time the array
     * needs to grow.
     */
    private void ensureCapacity() {
        if (this.elements.length == size) {
            this.elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
