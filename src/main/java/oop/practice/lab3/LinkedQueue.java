package oop.practice.lab3;

import java.util.LinkedList;

public class LinkedQueue<E> implements Queue<E> {
    private static final int DEFAULT_CAPACITY = 100;
    private LinkedList<E> list = new LinkedList<>();
    private int capacity;

    public LinkedQueue() {
        this(DEFAULT_CAPACITY);
    }

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    public void push(E item) {
        if (!isFull()) {
            list.addLast(item);
        } else {
            throw new IllegalStateException("Queue is full");
        }
    }

    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        return list.removeFirst();
    }

    public E peek() {
        return list.peekFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() == capacity;
    }

    public int size() {
        return list.size();
    }
}
