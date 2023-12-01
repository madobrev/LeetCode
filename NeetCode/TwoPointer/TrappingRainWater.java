package TwoPointer;

public class TrappingRainWater {

    public static int trap(int[] height) {

        if (height.length == 1 || height.length == 2) { // Both cases there will be no trapped water
            return 0;
        }

        int filledArea = 0;
        int toBeFilled = 0;

        int finalHighest = -1; // Used to mark the highest point in the graph, after which we start the reverse
        // algorithm.

        for (int begin = 0, end = 1; end < height.length; ) {// Begin from left to right [0] [1]

            int leftValue = height[begin];
            int rightValue = height[end];

            if (rightValue < leftValue) {// In this case there will be trapped water

                end++;// Update the right pointer
                toBeFilled += leftValue - rightValue;// Calculate the trapped water

            } else { // The right value is higher than the left value => We begin the algorith from
                // the beginning but with new two pointers
                filledArea += toBeFilled;// Update the trapped water so far
                begin = end; // Update the new pointers values
                end = end + 1;
                toBeFilled = 0;
            }

            if (end == height.length) {// End of the array has been reached => mark the highest latest point that we
                // have seen
                finalHighest = begin;
            }

        }

        filledArea = filledArea > 0 ? filledArea : 0; // There are cases, where we have collected negative water eg.
        // {4,2,3}

        toBeFilled = 0;
        for (int reverseBegin = height.length - 1, reverseEnd = height.length - 2; reverseBegin > finalHighest; ) {
            // Same algorithm, but this time backwards until we reach the previously marked
            // highest point

            int rightValue = height[reverseBegin];
            int leftValue = height[reverseEnd];

            if (leftValue < rightValue) {

                toBeFilled += rightValue - leftValue;
                reverseEnd--;
            } else {
                filledArea += toBeFilled;
                reverseBegin = reverseEnd;
                reverseEnd = reverseEnd - 1;
                toBeFilled = 0;

            }

        }

        return filledArea;

    }

    public static void main(String[] args) {
        // int[] height = { 4, 2, 3 };
        // int[] height2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int[] height3 = { 4, 2, 0, 3, 2, 5 };
        // int[] height4 = { 5, 5, 2, 6, 6, 3 };
        int[] height5 = {4, 3};

        System.out.println(trap(height5));
    }

}
