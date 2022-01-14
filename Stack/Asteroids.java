package ImportantQ.Stack;
import java.util.*;
// https://leetcode.com/problems/asteroid-collision/submissions/
public class Asteroids {
    // T-> O(n)
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                int temp = stack.pop();

                if (Math.abs(temp) > Math.abs(asteroid)) {
                    stack.push(temp);
                    flag = false; // you do not have to enter this element
                    break;
                } else if (Math.abs(temp) == Math.abs(asteroid)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                stack.push(asteroid);
        }

        if(stack.size() == 0)
            return new int[]{};

        int[] result = new int[stack.size()];

        for(int i = result.length - 1; i >= 0; i--){
            result[i] = stack.pop();
        }

        return result;

    }
}
