package DailyChallenges.November2023;
//https://leetcode.com/problems/largest-submatrix-with-rearrangements/description/?envType=daily-question&envId=2023-11-26

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

    public static int largestSubmatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxArea = 0;

        int[] h = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                h[j] = matrix[i][j] == 0 ? 0 : h[j] + 1;
            int[] sortedH = Arrays.copyOf(h, h.length);
            Arrays.sort(sortedH);
            for (int j = 0; j < cols; j++)
                maxArea = Math.max(maxArea, sortedH[j] * (cols - j));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        };

        System.out.println(largestSubmatrix(matrix));
    }
}
