package BinarySearch;

public class SearchingA2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {


        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (matrix[middle / columns][middle % columns] > target) {
                right = middle - 1;
            } else if (matrix[middle / columns][middle % columns] < target) {
                left = middle + 1;
            } else {
                return true;
            }
        }


        return false;

    }

    public static void main(String[] args) {

    }
}
