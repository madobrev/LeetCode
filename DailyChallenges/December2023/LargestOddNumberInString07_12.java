package DailyChallenges.December2023;

public class LargestOddNumberInString07_12 {
    public static String largestOddNumber(String num) {

        int right = num.length() - 1;

        while (right >= 0 && num.charAt(right) % 2 == 0) { //ASCII values '0' = 48 and '9' = 57 => no need to convert to Integer
            right--;
        }

        if (right >= 0) {
            return num.substring(0, right + 1);
        } else {
            return "";
        }

    }

    public static void main(String[] args) {
        String a = "52";

        System.out.println(largestOddNumber(a));
    }
}
