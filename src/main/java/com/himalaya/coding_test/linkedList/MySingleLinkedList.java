package com.himalaya.coding_test.linkedList;

public class MySingleLinkedList<T> {

    private Node<T> head;

    public void addNode(T data) {
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node<>(data);
        }
    }

    public void addNodeInside(T data, T isData) {
        Node<T> searchedNode = search(isData);
        if (searchedNode != null) {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node(data);
            searchedNode.next.next = nextNode;
        } else {
            addNode(data);
        }
    }

    public T deleteNode(T isData) {
        if (this.head == null) {
            return null;
        } else {
            Node<T> node = head;
            if (node.data == isData) {
                head = head.next;
                return node.data;
            } else {
                while (node.next != null) {
                    if (node.next.data == isData) {
                        Node<T> deletedNode = node.next;
                        node.next = node.next.next;
                        deletedNode.next = null;
                        return isData;
                    }
                    node = node.next;
                }
            }
        }
        return null;
    }

    private Node<T> search(T isData) {
        if (head == null) {
            return null;
        }
        Node<T> node = head;
        while (node != null) {
            if (node.data == isData) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void printAll() {
        Node<T> node = head;
        while (node != null) {
            System.out.println("node.data = " + node.data);
            node = node.next;
        }
    }

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        MySingleLinkedList<Integer> singleLinkedList = new MySingleLinkedList<>();
        singleLinkedList.addNode(1);
        singleLinkedList.addNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.addNodeInside(4, 2);
        singleLinkedList.addNodeInside(5, 5);
        singleLinkedList.deleteNode(5);

        System.out.println("singleLinkedList.head.data = " + singleLinkedList.head.data);
        System.out.println("singleLinkedList.head.next.data = " + singleLinkedList.head.next.data);
        singleLinkedList.printAll();
    }
}
