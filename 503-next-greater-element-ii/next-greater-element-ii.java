import java.util.Stack;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int num = nums[i % n];
            
            while (!st.isEmpty() && st.peek() <= num) {
                st.pop();
            }
            
            if (i < n) {
                arr[i] = st.isEmpty() ? -1 : st.peek();
            }
            
            st.push(num);
        }
        
        return arr;
    }
}
