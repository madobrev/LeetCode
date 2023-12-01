package Stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> mapOppositeBrackets = new HashMap<>();

        mapOppositeBrackets.put(')', '(');
        mapOppositeBrackets.put(']', '[');
        mapOppositeBrackets.put('}', '{');

        if (s.length() % 2 != 0 || mapOppositeBrackets.keySet().contains(s.charAt(0))) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char currentBracket = s.charAt(i);
            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (mapOppositeBrackets.get(currentBracket) == stack.peek()) {

                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
    }
}
