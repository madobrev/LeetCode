package SlidingWindow;


public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (n <= 1) {
            return n; // If the string has 0 or 1 characters, return its length (no repeating
            // characters possible).
        }

        int[] charIndex = new int[256]; // An array to keep track of the index of the last occurrence of each character
        // (assuming ASCII characters).
        int longestSubstringCount = 0; // To store the length of the longest substring without repeating characters.
        int left = 0; // The left pointer of the sliding window.
        int right = 0; // The right pointer of the sliding window.

        while (right < n) {
            char character = s.charAt(right); // Get the character at the right pointer.
            if (charIndex[character] > left) {
                // If the character has been encountered within the current window, move the
                // left pointer to the next position after the previous occurrence.
                left = charIndex[character];
            }
            // Calculate the length of the current substring and update the
            // longestSubstringCount if necessary.
            longestSubstringCount = Math.max(longestSubstringCount, right - left + 1);
            // Update the character's index to the current position.
            charIndex[character] = right + 1;
            right++; // Move the right pointer to the next character.
        }

        return longestSubstringCount; // Return the length of the longest substring without repeating characters.

    }

    public static void main(String[] args) {

    }
}
