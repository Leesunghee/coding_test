package com.himalaya.coding_test.linkedlist;

public class MyDoubleLinkedList <T> {

    public Node<T> head = null;
    public Node<T> tail = null;
    public class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            tail.next = new Node<>(data);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public boolean insertToFront(T data, T isData) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else if (head.data == isData) {
            Node<T> insertNode = new Node<T>(data);
            head.prev = insertNode;
            insertNode.next = head;
            head = insertNode;
            return true;
        } else {
            Node<T> node = head;
            while (node.next != null) {
                if (node.next.data == isData) {
                    Node<T> insertNode = new Node<>(data);
                    insertNode.next = node.next;
                    node.next.prev = insertNode;
                    node.next = insertNode;
                    insertNode.prev = node;
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }

    public void printAll() {
        Node<T> node = head;
        while (node != null) {
            System.out.println("node.data = " + node.data);
            node = node.next;
        }
        System.out.println("head.data = " + head.data);
        System.out.println("tail.data = " + tail.data);
    }

    public T searchFromHead(T isData) {
        if (head == null) {
            return null;
        }
        Node<T> node = head;
        while (node != null) {
            if (node.data == isData) {
                return node.data;
            }
            node = node.next;
        }
        return null;
    }

    public T searchFromTail(T isData) {
        if (tail == null) {
            return null;
        }
        Node<T> node = tail;
        while (node != null) {
            if (node.data == isData) {
                return node.data;
            }
            node = node.prev;
        }
        return null;
    }


    public static void main(String[] args) {

        MyDoubleLinkedList<Integer> linkedList = new MyDoubleLinkedList<>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.printAll();
        System.out.println("linkedList.searchFromHead(2) : " + linkedList.searchFromHead(2));
        System.out.println("linkedList.searchFromTail(2) : " + linkedList.searchFromTail(1));

        linkedList.insertToFront(4, 2);
        linkedList.printAll();

        linkedList.insertToFront(5, 1);
        linkedList.printAll();


    }
}
