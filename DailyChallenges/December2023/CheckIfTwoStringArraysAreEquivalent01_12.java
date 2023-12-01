package DailyChallenges.December2023;

//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/?envType=daily-question&envId=2023-12-01
//SOLVED
public class CheckIfTwoStringArraysAreEquivalent01_12 {


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int currentLetterIndexWord1 = 0;
        int currentLetterIndexWord2 = 0;
        int currentArrayIndexWord1 = 0;
        int currentArrayIndexWord2 = 0;

        while (currentArrayIndexWord1 < word1.length || currentArrayIndexWord2 < word2.length) {

            char firstArrayLetter = word1[currentArrayIndexWord1].charAt(currentLetterIndexWord1);
            char secondArrayLetter = word2[currentArrayIndexWord2].charAt(currentLetterIndexWord2);

            if (firstArrayLetter != secondArrayLetter) {
                return false;
            }


            if (currentLetterIndexWord1 + 1 == word1[currentArrayIndexWord1].length()) {
                currentLetterIndexWord1 = 0;
                currentArrayIndexWord1++;
            } else {
                currentLetterIndexWord1++;
            }

            if (currentLetterIndexWord2 + 1 == word2[currentArrayIndexWord2].length()) {
                currentLetterIndexWord2 = 0;
                currentArrayIndexWord2++;
            } else {
                currentLetterIndexWord2++;
            }

            if ((currentArrayIndexWord1 == word1.length && currentArrayIndexWord2 < word2.length) || (currentArrayIndexWord2 == word2.length && currentArrayIndexWord1 < word1.length)) {
                return false;
            }

        }

        return true;
    }


}
