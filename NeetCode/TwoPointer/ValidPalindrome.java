package TwoPointer;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        String clearedInput = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if (clearedInput == "") {
            return true;
        }

        for (int i = 0, j = clearedInput.length() - 1; i < clearedInput.length() / 2; i++, j--) {
            if (clearedInput.charAt(i) != clearedInput.charAt(j)) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {


    }

}