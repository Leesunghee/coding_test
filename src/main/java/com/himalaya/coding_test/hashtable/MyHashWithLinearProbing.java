package com.himalaya.coding_test.hashtable;

public class MyHashWithLinearProbing {
    public Slot[] hashTable;

    public MyHashWithLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;

        Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String data) {
        Integer currAddress = hashFunc(key);
        while (currAddress <= hashTable.length) {
            if (hashTable[currAddress] != null) {
                if (hashTable[currAddress].key == key) {
                    hashTable[currAddress].value = data;
                    return true;
                }
            } else {
                hashTable[currAddress] = new Slot(key, data);
                return true;
            }
            currAddress++;
        }
        return false;
    }

    public String getData(String key) {
        Integer currAddress = hashFunc(key);
        while (currAddress <= hashTable.length) {
            if (hashTable[currAddress] != null) {
                if (hashTable[currAddress].key == key) {
                    return hashTable[currAddress].value;
                }
            }
            currAddress++;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashWithLinearProbing hashTable = new MyHashWithLinearProbing(20);
        hashTable.saveData("DaveLee", "0101010101010");
        hashTable.saveData("fun-coding", "010101234234");
        hashTable.saveData("fun-coding2", "03333334");
        hashTable.saveData("Davee", "11111111");
        System.out.println("hashTable.getData(\"DaveLee\") = " + hashTable.getData("DaveLee"));
        System.out.println("hashTable.getData(\"fun-coding\") = " + hashTable.getData("fun-coding"));
        System.out.println("hashTable.getData(\"fun-coding2\") = " + hashTable.getData("fun-coding2"));
        System.out.println("hashTable.getData(\"Davee\") = " + hashTable.getData("Davee"));
    }

}
