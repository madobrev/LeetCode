package SlidingWindow;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int[] usedLetters2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            char currentCharacter = s1.charAt(i);
            usedLetters2[currentCharacter - 'a']++;
        }

        int[] tempUsedLetters = usedLetters2.clone();

        for (int i = 0; i < s2.length(); i++) {
            char currentCharacter = s2.charAt(i);
            if (tempUsedLetters[currentCharacter - 'a'] != 0) {
                tempUsedLetters[currentCharacter - 'a']--;
            }
        }

        for (int amountOfLetters : tempUsedLetters) {
            if (amountOfLetters > 0) {
                return false;
            }
        }

        tempUsedLetters = usedLetters2.clone();

        int counter = 0;
        int left = 0;
        int initialLeft = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {
            char currentCharacter = s2.charAt(left);

            if (usedLetters2[currentCharacter - 'a'] > 0) {
                usedLetters2[currentCharacter - 'a']--;
                counter++;
                left++;
            } else {
                left = initialLeft + 1;
                right++;
                initialLeft = left;
                counter = 0;
                usedLetters2 = tempUsedLetters.clone();
            }

            if (counter == s1.length()) {
                return true;
            }

        }

        return false;
    }

    public static void main(String[] args) {

    }
}
