package DailyChallenges.November2023;

import java.util.Stack;

//https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero/description/?envType=daily-question&envId=2023-11-30
public class MinimumOneBitOperationsToMakeIntegersZero {

    public static int minimumOneBitOperations(int n) {

        if (n == 0) {
            return 0;
        }
        String binaryRepresentation = Integer.toBinaryString(n);
        Stack<Integer> powers = new Stack<>();
        int powerCounter = 0;

        for (int i = binaryRepresentation.length() - 1; i >= 0; i--) {
            char bit = binaryRepresentation.charAt(i);
            if (bit == '1') {
                powers.push(powerCounter);
            }
            powerCounter++;
        }

        int totalOperations = (int) Math.pow(2, powers.pop() + 1) - 1;
        boolean isNextOperationSubtraction = true;

        while (!powers.isEmpty()) {

            if (isNextOperationSubtraction) {
                totalOperations -= (int) Math.pow(2, powers.pop() + 1) - 1;
                isNextOperationSubtraction = false;
            } else {
                totalOperations += (int) Math.pow(2, powers.pop() + 1) - 1;
                isNextOperationSubtraction = true;
            }
        }

        return totalOperations;
    }

    public static void main(String[] args) {

    }
}
