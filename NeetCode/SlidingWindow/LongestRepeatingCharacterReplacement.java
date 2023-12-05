package SlidingWindow;

//TODO do the problem
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 1;

        int remainingSwaps = k;
        int longestSubstring = 1;
        int nextLeftIndex = -1;

        while (right < s.length()) {

            boolean areCharactersUnequal = s.charAt(right) != s.charAt(left);

            if (areCharactersUnequal && remainingSwaps > 0) {
                if (nextLeftIndex == -1) {
                    nextLeftIndex = right;
                }
                remainingSwaps--;
            } else if (areCharactersUnequal && remainingSwaps == 0) {
                longestSubstring = Math.max(longestSubstring, right - left);

                if (k == 0) { // no replacements available => just continue counting through the String with the new letter
                    left = right;
                    right = left + 1;
                } else {
                    left = nextLeftIndex;
                    right = left;
                    nextLeftIndex = -1;
                    remainingSwaps = k;
                }
            }
            right++;
        }
        longestSubstring = Math.max(longestSubstring, right - left);
        boolean areThereRepeatingCharactersAtTheEnd = left + 1 != s.length() - 1 && s.substring(left + 1).matches("^([a-zA-Z])\\1*$");

        if (remainingSwaps > 0 || areThereRepeatingCharactersAtTheEnd) {
            if (areThereRepeatingCharactersAtTheEnd) {
                remainingSwaps = k;
            }
            right = left;
            while (remainingSwaps > 0) {
                if (left <= 1) {
                    left = 0;
                    break;
                }
                if (s.charAt(right) != s.charAt(left - 1)) {
                    remainingSwaps--;
                }
                left = Math.max(left - 1, 1);
            }
            longestSubstring = Math.max(longestSubstring, s.length() - left);
        }

        return longestSubstring;
    }

    public static void main(String[] args) {
        String s1 = "ABBBC";
        int k1 = 2;
        String s2 = "ABCDE";
        int k2 = 1;
        String s3 = "AABABBA";
        int k3 = 3;
        String s4 = "ABCDDD";
        int k4 = 3;

        System.out.println(characterReplacement(s2, k2));

    }

}
