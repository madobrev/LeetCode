package DailyChallenges.December2023;
//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/?envType=daily-question&envId=2023-12-02

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindWordsThatCanBeFormedByCharacters02_12 {

    public int countCharacters(String[] words, String chars) {

        HashMap<Character, Integer> amountOfOccurrences = new HashMap<>();
        List<Character> toBeReinserted = new ArrayList<>();
        int totalCount = 0;

        for (int i = 0; i < chars.length(); i++) {// count the characters
            char currentChar = chars.charAt(i);
            amountOfOccurrences.put(currentChar, amountOfOccurrences.getOrDefault(currentChar, 0) + 1);
        }

        for (String word : words) {
            boolean isWordPossible = true;

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);

                if (amountOfOccurrences.get(currentChar) == null || amountOfOccurrences.get(currentChar) == 0) {
                    // if the character is not in the HashMap/ all occurrences have been used, discard the word
                    isWordPossible = false;
                    break;
                } else {
                    toBeReinserted.add(currentChar);// need to keep track of the seen letters and update the HashMap accordingly
                    amountOfOccurrences.put(currentChar, amountOfOccurrences.get(currentChar) - 1);
                    totalCount++;
                }

            }
            for (char toInsert : toBeReinserted) { // reset the HashMap to its original state
                amountOfOccurrences.put(toInsert, amountOfOccurrences.getOrDefault(toInsert, 0) + 1);
                if (!isWordPossible) {
                    totalCount--;
                }
            }
            toBeReinserted.clear();
        }

        return totalCount;
    }

}
