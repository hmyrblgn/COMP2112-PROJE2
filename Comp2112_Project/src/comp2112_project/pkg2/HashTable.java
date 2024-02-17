/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp2112_project.pkg2;



public class HashTable<T> {
    private Object[] table;  // Generics ile doğrudan dizi oluşturulamaz, Object kullanılır
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new Object[capacity];
        this.size = 0;
    }

    private int hashFunction(T key) {
        String keyStr = key.toString();
        int hash = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            hash = 97 * hash + keyStr.charAt(i);
        }
        return Math.abs(hash) % capacity;
    }

    private int linearProbe(int hash) {
        int probeIndex = hash;
        while (table[probeIndex] != null) {
            probeIndex = (probeIndex + 1) % capacity;
        }
        return probeIndex;
    }

    public boolean put(T key) {
        if (size >= capacity) {
            throw new IllegalStateException("Hash table is full.");
        }

        int hash = hashFunction(key);
        if (table[hash] == null) {
            table[hash] = key;
        } else {
            int probeIndex = linearProbe(hash);
            table[probeIndex] = key;
        }
        size++;
        return true;
    }

    public boolean contains(T key) {
        int hash = hashFunction(key);
        int probeIndex = hash;
        while (table[probeIndex] != null) {
            if (table[probeIndex].equals(key)) {
                return true;
            }
            probeIndex = (probeIndex + 1) % capacity;
            if (probeIndex == hash) {  // Tüm tablo tarandı, öğe bulunamadı
                return false;
            }
        }
        return false;
    }

    public boolean remove(T key) {
        int hash = hashFunction(key);
        int probeIndex = hash;
        while (table[probeIndex] != null) {
            if (table[probeIndex].equals(key)) {
                table[probeIndex] = null;  // Silme işlemi, yerine null koymak
                size--;
                return true;
            }
            probeIndex = (probeIndex + 1) % capacity;
            if (probeIndex == hash) {  // Tüm tablo tarandı, öğe bulunamadı
                return false;
            }
        }
        return false;
    }
}

