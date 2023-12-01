package DailyChallenges.November2023;

// https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/?envType=daily-question&envId=2023-11-24
// SOLVED

import java.util.Arrays;

public class MaximumNumberOfCoinsYouCanGet {

    public static int maxCoins(int[] piles) {

        int result = 0;
        Arrays.sort(piles);

        int playerIndex = piles.length - 2;

        while (playerIndex >= piles.length / 3) {
            result += piles[playerIndex];
            playerIndex -= 2;
        }
        return result;

    }

    public static void main(String[] args) {

        int[] piles = {2, 4, 1, 2, 7, 8};

        System.out.println(maxCoins(piles));
    }
}
