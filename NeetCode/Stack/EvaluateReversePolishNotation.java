package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.valueOf(tokens[0]);
        }

        Stack<Integer> valuesStack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            char firstChar = token.charAt(0);

            if (Character.isDigit(firstChar) || (token.length() > 1 && firstChar == '-')) {
                valuesStack.push(Integer.parseInt(token));
            } else {
                switch (token) {
                    case "+":
                        valuesStack.push(valuesStack.pop() + valuesStack.pop());
                        break;
                    case "-":
                        valuesStack.push(-valuesStack.pop() + valuesStack.pop());
                        break;

                    case "*":
                        valuesStack.push(valuesStack.pop() * valuesStack.pop());
                        break;

                    case "/":
                        int divisor = valuesStack.pop();
                        int divident = valuesStack.pop();
                        valuesStack.push(divident / divisor);
                        break;
                }
            }
        }
        return valuesStack.pop();
    }

    public static void main(String[] args) {
    }
}
