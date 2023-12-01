package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack;
    private int currentMin;
    private List<Integer> orderTracker;

    public MinStack() {
        currentMin = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
        orderTracker = new ArrayList<>();
    }

    public void push(int val) {
        currentMin = Math.min(currentMin, val);
        stack.push(val);
        orderTracker.add(val);
        Collections.sort(orderTracker);
    }

    public void pop() {
        int removedTopNumber = stack.pop();
        int removedIndex = orderTracker.indexOf(removedTopNumber);
        orderTracker.remove(removedIndex);

        if (stack.isEmpty()) {
            currentMin = Integer.MAX_VALUE;
        } else {
            if (removedTopNumber == currentMin) {
                currentMin = orderTracker.get(0);
            }
        }

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return currentMin;
    }

}
