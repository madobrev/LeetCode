package DailyChallenges.December2023;

//https://leetcode.com/problems/largest-3-same-digit-number-in-string/description/?envType=daily-question&envId=2023-12-04
public class Largest3SameDigitNumberInString04_12 {
    public String largestGoodInteger(String num) {
        int largestDigit = -1;

        for (int i = 0; i <= num.length() - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 2) && num.charAt(i) == num.charAt(i + 1)) {
                largestDigit = Math.max(largestDigit, num.charAt(i) - 48);
                i += 2;
            }
        }

        return largestDigit == -1 ? "" : String.valueOf(largestDigit).repeat(3);
    }

}
