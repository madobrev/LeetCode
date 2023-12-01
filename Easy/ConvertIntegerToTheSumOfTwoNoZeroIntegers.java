package Easy;
//https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/description/
//SOLVED

import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public static int[] getNoZeroIntegers(int n) {
        int a = 1;
        int b = n - 1;

        while (String.valueOf(a).contains("0") || String.valueOf(b).contains("0")) {
            a++;
            b--;
        }

        return new int[]{a, b};
    }

    public static void main(String[] args) {

        int a = 1010;

        System.out.println(Arrays.toString(getNoZeroIntegers(a)));
    }
}
