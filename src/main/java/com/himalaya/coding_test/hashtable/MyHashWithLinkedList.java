package com.himalaya.coding_test.hashtable;

public class MyHashWithLinkedList {
    public Slot[] hashTable;

    public MyHashWithLinkedList(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        Slot next;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String data) {
        int address = hashFunc(key);
        if (hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = data;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, data);
            return true;
        } else {
            hashTable[address] = new Slot(key, data);
        }
        return true;
    }

    public String getData(String key) {
        Integer address = hashFunc(key);

        if (hashTable[address] != null) {
            Slot findSlot = hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                }
                findSlot = findSlot.next;
            }
            return null;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashWithLinkedList hashTable = new MyHashWithLinkedList(20);
        hashTable.saveData("DaveLee", "0101010101010");
        hashTable.saveData("fun-coding", "010101234234");
        hashTable.saveData("fun-coding2", "03333334");
        System.out.println("hashTable.getData(\"DaveLee\") = " + hashTable.getData("DaveLee"));
        System.out.println("hashTable.getData(\"fun-coding\") = " + hashTable.getData("fun-coding"));
        System.out.println("hashTable.getData(\"fun-coding2\") = " + hashTable.getData("fun-coding2"));
    }

}
