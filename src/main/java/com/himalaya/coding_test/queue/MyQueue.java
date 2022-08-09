package com.himalaya.coding_test.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue<T> {

    private List<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (isEmpty())
            return null;
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }


    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);

        myQueue.print();
        myQueue.dequeue();
        myQueue.print();
    }

    private void print() {
        queue.forEach(e -> System.out.println("e = " + e));
        System.out.println("==========");
    }
}
