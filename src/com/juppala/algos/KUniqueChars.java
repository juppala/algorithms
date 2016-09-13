/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juppala.algos;

/**
 *
 * @author juppala
 */
public class KUniqueChars {

    static int MAX_CHARS = 26;

    static boolean isValid(int count[], int k) {
        int val = 0;
        for (int i = 0; i < MAX_CHARS; i++) {
            if (count[i] > 0) {
                val++;
            }
        }
        // Return true if k is greater than or equal to val
        return (k >= val);
    }

    // Finds the maximum substring with exactly k unique chars
    static void kUniques(String s, int k) {
        int u = 0; // number of unique characters
        int n = s.length();
        char c[] = s.toCharArray();

        // Associative array to store the count of characters
        int count[] = new int[MAX_CHARS];

    // Traverse the string, Fills the associative array
        // count[] and count number of unique characters
        for (int i = 0; i < n; i++) {
            if (count[c[i] - 'a'] == 0) {
                u++;
            }
            count[c[i] - 'a']++;
        }

    // If there are not enough unique characters, show
        // an error message.
        if (u < k) {
            System.out.println("Not enough unique characters");
            return;
        }

    // Otherwise take a window with first element in it.
        // start and end variables.
        int curr_start = 0, curr_end = 0;

        // Also initialize values for result longest window
        int max_window_size = 1, max_window_start = 0;


        count[c[0] - 'a']++;  // put the first character

    // Start from the second character and add
        // characters in window according to above
        // explanation
        for (int i = 1; i < n; i++) {
            // Add the character 's[i]' to current window
            count[c[i] - 'a']++;
            curr_end++;

        // If there are more than k unique characters in
            // current window, remove from left side
            while (!isValid(count, k)) {
                count[c[curr_start] - 'a']--;
                curr_start++;
            }

            // Update the max window size if required
            if (curr_end - curr_start + 1 > max_window_size) {
                max_window_size = curr_end - curr_start + 1;
                max_window_start = curr_start;
            }
        }
        System.out.println("Max sustring is : "+s.substring(max_window_start, max_window_size) + " with length " + max_window_size);
    }

    public static void main(String args[]) {
        String input_str = "aabbcc";
        int n = input_str.length();
        int unique = 2;
        kUniques(input_str, unique);
    }
}
