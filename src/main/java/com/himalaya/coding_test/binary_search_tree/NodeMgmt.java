package com.himalaya.coding_test.binary_search_tree;

public class NodeMgmt {

    private Node root;

    public class Node {
        Node left;
        Node right;
        int value;

        public Node(int data) {
            this.value = data;
            left = null;
            right = null;
        }
    }

    public boolean insertNode(int data) {
        //CASE1: Node 가 하나도 없을 때
        if (root == null) {
            root = new Node(data);
            return true;
        } else {
            //CASE2: Node 가 하나 이상 있을 때
            Node node = root;
            while (true) {
                //CASE2-1: 현재 Node 의 왼쪽에 Node 가 들어 가야할 때
                if (node.value > data) {
                    if (node.left == null) {
                        node.left = new Node(data);
                        return true;
                    }
                    node = node.left;
                } else { //CASE2-2: 현재 Node 의 오른쪽에 Node 가 들어 가야할 때
                    if (node.right == null) {
                        node.right = new Node(data);
                        return true;
                    }
                    node = node.right;
                }
            }
        }
    }

    public Node search(int data) {
        if (root == null) {
            return null;
        }
        Node node = root;
        while (node != null) {
            if (node.value == data) {
                return node;
            }
            if (node.value > data) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public boolean delete(int data) {

        Node node = root;
        Node parentNode = root;

        //CASE 1: Node 가 하나도 없을 때
        if (root == null) {
            return false;
        } else {
            //CASE 2: Node 가 단지 하나만 있고, 해당 Node 가 삭제할 Node 일 때
            if (node.value == data && node.left == null && node.right == null) {
                root = null;
                return true;
            }
        }

        while (node != null) {
            if (node.value == data) {
                //CASE 3: Node 가 삭제 대상이고 Leaf Node 일 때
                if (node.left == null && node.right == null) {
                    if (parentNode.value > data) {
                        parentNode.left = null;
                    } else {
                        parentNode.right = null;
                    }
                    return true;
                }
            }
            if (node.value > data) {
                parentNode = node;
                node = node.left;
            } else {
                parentNode = node;
                node = node.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        NodeMgmt bst = new NodeMgmt();
        bst.insertNode(3);
//        bst.insertNode(7);
//        bst.insertNode(1);
//        bst.insertNode(9);

//        System.out.println("bst.search(3).value = " + bst.search(3).value);
//        System.out.println("bst.search(7).value = " + bst.search(7).value);
//        System.out.println("bst.search(1).value = " + bst.search(1).value);
//        System.out.println("bst.search(9).value = " + bst.search(9).value);
//        System.out.println("bst.search(5).value = " + (bst.search(5) == null ? "null" : bst.search(5).value));

//        bst.delete(1);
//        System.out.println("bst.search(1).value = " + (bst.search(1) == null ? "null" : bst.search(1).value));

        bst.delete(3);
        System.out.println("bst.search(3).value = " + (bst.search(3) == null ? "null" : bst.search(3).value));
    }
}
