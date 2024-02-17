/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp2112_project.pkg2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

    private HashTable<String> dictionary;

    public Dictionary() {
        dictionary = new HashTable<>(500000);
    }

    private String convertToEnglish(String word) {
        return word.replace('ç', 'c')
                   .replace('ğ', 'g')
                   .replace('ı', 'i')
                   .replace('ö', 'o')
                   .replace('ş', 's')
                   .replace('ü', 'u')
                   .toLowerCase()
                   .replaceAll("[^a-z]", "");
    }

    public void loadDictionary(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Noktalama işaretleriyle de kelime ayırma
                String[] words = line.split("[\\s.,;!?\"'():-]+");
                for (String word : words) {
                    dictionary.put(convertToEnglish(word));
                }
            }
            System.out.println("Yüklendi dosya");
        }
    }

    public boolean searchWord(String word) {
        return dictionary.contains(convertToEnglish(word));
    }

    public boolean insertWord(String word) {
        return dictionary.put(convertToEnglish(word));
    }

    public boolean deleteWord(String word) {
        return dictionary.remove(convertToEnglish(word));
    }

    public void spellCheck(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Noktalama işaretleriyle de kelime ayırma
                String[] words = line.split("[\\s.,;!?\"'():-]+");
                for (String word : words) {
                    String cleanedWord = convertToEnglish(word);
                    if (!cleanedWord.isEmpty() && !dictionary.contains(cleanedWord)) {
                        System.out.println("Spelling error: " + cleanedWord);
                    }
                }
            }
        }
    }
}
