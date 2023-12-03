package DailyChallenges.December2023;
//https://leetcode.com/problems/minimum-time-visiting-all-points/description/?envType=daily-question&envId=2023-12-03

public class MinimumTimeVisitingAllPoints03_12 {


    private int currentX;
    private int currentY;

    public int checkForDifferenceOnTheSameAxis(int nextX, int nextY) {
        if (currentX == nextX) { // if next point in on the same X/Y axis, we only need the difference between the values on the other axis
            return Math.abs(currentY - nextY);
        } else if (currentY == nextY) {
            return Math.abs(currentX - nextX);
        }
        return 0;
    }

    public int traverseDiagonally(int nextX, int nextY, int xDirection, int yDirection) {

        boolean isXIncreasing = xDirection == 1;
        boolean isYIncreasing = yDirection == 1;

        int timeTraversed = 0;

        while (((isXIncreasing && isYIncreasing) && currentX < nextX && currentY < nextY) || // X Increasing Y Increasing
                ((isXIncreasing && !isYIncreasing) && currentX < nextX && currentY > nextY) || // X Increasing Y Decreasing
                ((!isXIncreasing && isYIncreasing) && currentX > nextX && currentY < nextY) || // X Decreasing Y Increasing
                ((!isXIncreasing && !isYIncreasing) && currentX > nextX && currentY > nextY)) { // X Decreasing Y Decreasing
            currentX += xDirection;
            currentY += yDirection;
            timeTraversed++;
        }

        return timeTraversed;
    }


    public int minTimeToVisitAllPoints(int[][] points) {

        int time = 0;

        for (int i = 0; i <= points.length - 2; i++) {
            // Can be done without iteration from one coordinate to another and the need of all the other methods.
            // The distance between two points is the maximum from the abstract result between
            // nextX minus currentX and nextY minus currentY
            currentX = points[i][0];
            currentY = points[i][1];

            int nextX = points[i + 1][0];
            int nextY = points[i + 1][1];

            if (currentX == nextX || currentY == nextY) {
                time += checkForDifferenceOnTheSameAxis(nextX, nextY);
                continue;
            }

            boolean isXMovementPositive = nextX > currentX;
            boolean isYMovementPositive = nextY > currentY;

            // Fastest way from point A to B is to maximize the diagonal movement
            if (isXMovementPositive && isYMovementPositive) {// X positive | Y positive
                time += traverseDiagonally(nextX, nextY, 1, 1);
                time += checkForDifferenceOnTheSameAxis(nextX, nextY);
            } else if (isXMovementPositive) { // X positive | Y negative
                time += traverseDiagonally(nextX, nextY, 1, -1);
                time += checkForDifferenceOnTheSameAxis(nextX, nextY);
            } else if (isYMovementPositive) { // X negative | Y positive
                time += traverseDiagonally(nextX, nextY, -1, 1);
                time += checkForDifferenceOnTheSameAxis(nextX, nextY);
            } else {// X negative | Y negative
                time += traverseDiagonally(nextX, nextY, -1, -1);
                time += checkForDifferenceOnTheSameAxis(nextX, nextY);
            }

        }

        return time;
    }

}
