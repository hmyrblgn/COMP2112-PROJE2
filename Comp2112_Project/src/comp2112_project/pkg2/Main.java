/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp2112_project.pkg2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author humeyrabilgin
 */

public class Main {

    public static void main(String[] args) throws IOException {
        Dictionary dictionaryChecker = new Dictionary();
        Scanner scan = new Scanner(System.in);

        // Load dictionary from "dict.txt"
        System.out.println();
        int choose = 0;
        String  word=" ";
        while (true) {
            System.out.println("1. Load a dictionary from a given text file.");
            System.out.println("2. Search for an entry in this dictionary in constant time.");
            System.out.println("3. Insert a word to the dictionary in constant time.");
            System.out.println("4. Delete a word from the dictionary in constant time.");
            System.out.println("5. Given a random text file, do a spell check in linear time.");

            choose = scan.nextInt();
           
            
            if (choose == 1) {
              dictionaryChecker.loadDictionary("dict.txt");
            } else if (choose == 2) {
               System.out.print("Enter word: ");
               word =scan.next();
              if(dictionaryChecker.searchWord(word)){
                  System.out.println("Kelime Bulundu!");
              }
              else{
                  System.out.println("Kelime Bulunamadı!");
              }
            } else if (choose == 3) {
               System.out.print("Enter word: ");
               word =scan.next();
               if(dictionaryChecker.insertWord(word)){
                   System.out.println("Kelime Eklendi!");
               }
               else{
                  System.out.println("Kelime Zaten Ekli!");
              }
            } else if (choose == 4) {
                System.out.print("Enter word: ");
                word =scan.next();
                if(dictionaryChecker.deleteWord(word)){
                   System.out.println("Kelime Silindi!");
               }
               else{
                  System.out.println("Kelime Ekli Değil!");
              }
            } else if (choose == 5) {
                dictionaryChecker.spellCheck("mydictionary.txt");
            }

        }
        // Example usage of the other methods can be included here as needed
    }
}
