// public class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int n = heights.length;
//         int maxArea = 0;
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i <= n; i++) {
//             while (!stack.isEmpty() &&
//                  (i == n || heights[stack.peek()] >= heights[i])) {
//                 int height = heights[stack.pop()];
//                 int width = stack.isEmpty() ? i : i - stack.peek() - 1;
//                 maxArea = Math.max(maxArea, height * width);
//             }
//             stack.push(i);
//         }
//         return maxArea;
//     }
// }
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // pair: (index, height)

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack) {
            int index = pair[0];
            int height = pair[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}