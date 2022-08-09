package com.himalaya.coding_test.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue2 {

    private Queue<Integer> queue = new LinkedList<>();


    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
        myQueue.queue.offer(1);
        myQueue.queue.offer(2);
        myQueue.queue.offer(3);
        System.out.println("myQueue.queue.poll() = " + myQueue.queue.poll());
        System.out.println("myQueue.queue.poll() = " + myQueue.queue.poll());
        System.out.println("myQueue.queue.poll() = " + myQueue.queue.poll());
    }
}
