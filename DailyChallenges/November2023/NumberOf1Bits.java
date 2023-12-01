package DailyChallenges.November2023;
//https://leetcode.com/problems/number-of-1-bits/description/?envType=daily-question&envId=2023-11-29
//Sovlved

public class NumberOf1Bits {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        int amountOfOnes = 0;

        while (n != 0) {
            amountOfOnes = amountOfOnes + (1 & n);
            n = n >>> 1;
        }

        return amountOfOnes;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
