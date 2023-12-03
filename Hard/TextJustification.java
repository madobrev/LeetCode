package Hard;
//https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public static String createNewRow(List<String> wordsInCurrentRow, int currentRowWidth, int maxWidth, boolean isFinalRow) {
        int blanksPerPadding;
        int leftoverBlanks = 0;
        int totalPaddings = maxWidth - currentRowWidth;

        if (wordsInCurrentRow.size() > 1) {// more than 1 word per row
            blanksPerPadding = (maxWidth - currentRowWidth) / (wordsInCurrentRow.size() - 1); // minimum amount of blanks
            leftoverBlanks = (maxWidth - currentRowWidth) % (wordsInCurrentRow.size() - 1); // the first x paddings have 1 more blank
        } else {// only 1 word in the row => left justified
            blanksPerPadding = totalPaddings;
        }


        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < wordsInCurrentRow.size(); i++) {
            String word = wordsInCurrentRow.get(i);

            if (isFinalRow) {// Left justified
                if (wordsInCurrentRow.size() > 1) { // only more than 1 word in the last row => word_word_word_____
                    stringBuilder.append(word);
                    if (i == wordsInCurrentRow.size() - 1) {// this is the final word => append all the left blanks
                        stringBuilder.append(" ".repeat(totalPaddings));
                    } else {// this isn't the final word => append only 1 blank
                        stringBuilder.append(" ");
                        totalPaddings = Math.max(totalPaddings - 1, 0);
                    }
                } else { // only 1 word in the last row => left justified
                    stringBuilder.append(word);
                    stringBuilder.append(" ".repeat(blanksPerPadding));
                }
            } else {
                if (wordsInCurrentRow.size() > 1) {
                    stringBuilder.append(word);
                    stringBuilder.append(" ".repeat(blanksPerPadding));
                    if (leftoverBlanks > 0) {
                        stringBuilder.append(" ");
                        leftoverBlanks--;
                    }
                } else { // only 1 word in the row => left justified
                    stringBuilder.append(word);
                    stringBuilder.append(" ".repeat(blanksPerPadding));
                }
            }
        }

        String row = stringBuilder.toString();

        if (wordsInCurrentRow.size() > 1 && !isFinalRow) { // since at the end of the loop we have added 1 more padding that needs to get trimmed
            row = row.trim();
        }
        return row;
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> wordsInCurrentRow = new ArrayList<>();
        int currentRowWidth = 0;

        for (int i = 0; i < words.length; i++) {
            currentRowWidth += words[i].length();
            wordsInCurrentRow.add(words[i]);

            if (i + 1 < words.length) {
                if ((words[i + 1].length() + currentRowWidth + wordsInCurrentRow.size()) > maxWidth) {
                    // next word length  +  length of all words on row for until now + number of paddings (starting with minimum 1 blank per padding)
                    // note that the number of intervals is the amount of words per row - 1. Here we don't subtract 1
                    // since wordsInCurrentRow would get updated in the next loop iteration

                    result.add(createNewRow(wordsInCurrentRow, currentRowWidth, maxWidth, false));
                    wordsInCurrentRow.clear();
                    currentRowWidth = 0;
                }
            } else {
                result.add(createNewRow(wordsInCurrentRow, currentRowWidth, maxWidth, true));
            }
        }
        return result;
    }

}
