package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    final static int AMOUNT_OF_ROWS_AND_COLUMS = 9;

    public boolean isValidSudoku(char[][] board) {
        Set<Character> leftBox = null;
        Set<Character> middleBox = null;
        Set<Character> rightBox = null;

        for (int row = 0; row < AMOUNT_OF_ROWS_AND_COLUMS; row++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            if (row % 3 == 0) {
                leftBox = new HashSet<>();
                middleBox = new HashSet<>();
                rightBox = new HashSet<>();
            }

            for (int col = 0; col < AMOUNT_OF_ROWS_AND_COLUMS; col++) {
                char currentCharForRowTracking = board[row][col];
                char currentCharForColTracking = board[col][row];

                if (currentCharForRowTracking != '.') {

                    if (rowSet.contains(currentCharForRowTracking)) {
                        return false;
                    }
                    rowSet.add(currentCharForRowTracking);

                    if (col <= 2) {
                        if (leftBox.contains(currentCharForRowTracking)) {
                            return false;
                        }
                        leftBox.add(currentCharForRowTracking);

                    } else if (col <= 5) {
                        if (middleBox.contains(currentCharForRowTracking)) {
                            return false;
                        }
                        middleBox.add(currentCharForRowTracking);
                    } else {
                        if (rightBox.contains(currentCharForRowTracking)) {
                            return false;
                        }
                        rightBox.add(currentCharForRowTracking);
                    }
                }

                if (currentCharForColTracking != '.') {

                    if (colSet.contains(currentCharForColTracking)) {
                        return false;
                    }
                    colSet.add(currentCharForColTracking);
                }

            }
        }
        return true;
    }
}