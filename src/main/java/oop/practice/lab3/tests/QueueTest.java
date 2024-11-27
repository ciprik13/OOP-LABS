package oop.practice.lab3.tests;

import oop.practice.lab3.ArrayQueue;
import oop.practice.lab3.LinkedQueue;
import oop.practice.lab3.Queue;
import oop.practice.lab3.VectorQueue;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {

    @Test
    public void testArrayQueue() {
        Queue<Integer> queue = new ArrayQueue<>();
        assertTrue(queue.isEmpty());
        queue.push(1);
        assertEquals(1, queue.peek());
        queue.push(2);
        assertEquals(2, queue.size());
        assertEquals(1, queue.pop());
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testLinkedQueue() {
        Queue<String> queue = new LinkedQueue<>(2);
        queue.push("A");
        queue.push("B");
        assertThrows(IllegalStateException.class, () -> queue.push("C"));
        assertEquals("A", queue.pop());
        assertEquals("B", queue.peek());
    }

    @Test
    public void testVectorQueue() {
        Queue<Double> queue = new VectorQueue<>();
        queue.push(3.14);
        queue.push(2.71);
        assertEquals(3.14, queue.pop());
        assertEquals(1, queue.size());
        assertEquals(2.71, queue.peek());
    }
}

