/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.wordguessinggame;

/**
 *
 * @author vaish
 */
import java.util.*;

public class WordGuessingGame {
    public static void main(String args[]) {

        // List of words
        String[] words = {"java", "computer", "program", "keyboard", "mouse"};

        // Generate random word
        Random random = new Random();
        String wordToGuess = words[random.nextInt(words.length)];

        int attempts = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Word Guessing Game!");
        System.out.println("Guess the correct word.");
        System.out.println("Hint: The word has " + wordToGuess.length() + " letters.");

        while (true) {
            System.out.print("Enter your guess: ");
            String userGuess = scanner.nextLine().trim();  // removes extra spaces

            if (userGuess.isEmpty()) {
                System.out.println("Please enter a word!");
                continue;
            }

            attempts++;

            if (userGuess.equalsIgnoreCase(wordToGuess)) {
                System.out.println("Congratulations! You guessed the word in "
                        + attempts + " attempts.");
                break;
            } else {
                System.out.println("Wrong guess! Try again.");
            }
        }
        scanner.close();
    }
}
