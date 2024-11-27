package oop.practice.lab3;

import java.util.Vector;

public class VectorQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private Vector<E> vector = new Vector<>();
    private int capacity;

    public VectorQueue() {
        this(DEFAULT_CAPACITY);
    }

    public VectorQueue(int capacity) {
        this.capacity = capacity;
    }

    public void push(E item) {
        if (!isFull()) {
            vector.add(item);
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return vector.remove(0);
    }

    public E peek() {
        return vector.firstElement();
    }

    public boolean isEmpty() {
        return vector.isEmpty();
    }

    public boolean isFull() {
        return vector.size() == capacity;
    }

    public int size() {
        return vector.size();
    }
}
