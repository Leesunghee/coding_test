package com.himalaya.coding_test.hashtable;

public class MyHash {
    public Slot[] hastTable;

    public MyHash(Integer size) {
        this.hastTable = new Slot[size];
    }

    public class Slot {
        String value;

        Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int) (key.charAt(0)) % this.hastTable.length;
    }

    public boolean saveData(String key, String data) {
        int address = hashFunc(key);
//        if (hastTable[address] != null) {
//            return false;
//        }
        hastTable[address] = new Slot(data);
        return true;
    }

    public String getData(String key) {
        if (hastTable[hashFunc(key)] != null)
            return hastTable[hashFunc(key)].value;
        return null;
    }

    public static void main(String[] args) {
        MyHash hashTable = new MyHash(20);
        hashTable.saveData("DaveLee", "0101010101010");
        hashTable.saveData("fun-coding", "010101234234");
        hashTable.saveData("fun-coding", "03333334");
        System.out.println("hashTable.getData(\"DaveLee\") = " + hashTable.getData("DaveLee"));
        System.out.println("hashTable.getData(\"fun-coding\") = " + hashTable.getData("fun-coding"));
        System.out.println("hashTable.getData(\"fun-coding2\") = " + hashTable.getData("fun-coding1234"));
    }

}
