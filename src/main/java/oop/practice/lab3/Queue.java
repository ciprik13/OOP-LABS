package oop.practice.lab3;

public interface Queue<E> {
    int DEFAULT_CAPACITY = 100;

    void push(E item);
    E pop();
    E peek();
    boolean isEmpty();
    boolean isFull();
    int size();
}
