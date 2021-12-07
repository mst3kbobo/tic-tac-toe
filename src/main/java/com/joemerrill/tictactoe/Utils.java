package com.joemerrill.tictactoe;

public class Utils {

    /**
     * Checks a String array if all elements are the equal each other.
     * Uses String.equals()
     * Examples:
     * : ["X","X","X"] = true
     * : ["-","O","X"] = false
     * @param array String array to check
     * @return True if all elements are the same. Otherwise, false.
     */
    public static boolean areArrayElementsSame(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (!array[0].equals(array[i])) {
                return false;
            }
        }
        return true;
    }
}
