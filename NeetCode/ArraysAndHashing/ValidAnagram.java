package ArraysAndHashing;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] firstStringAsCharArray = s.toCharArray();
        char[] secondStringAsCharArray = t.toCharArray();
        Arrays.sort(firstStringAsCharArray);
        Arrays.sort(secondStringAsCharArray);

        for (int i = 0; i < firstStringAsCharArray.length; i++) {
            if (firstStringAsCharArray[i] != secondStringAsCharArray[i]) {
                return false;
            }
        }
        return true;
    }
}
