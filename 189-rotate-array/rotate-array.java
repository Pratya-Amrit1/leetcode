// class Solution {
//     public void rotate(int[] nums, int k) {
//          int n=nums.length;
//         int[] arr =new int[n];
//         for(int i=0;i<n;i++){
//             arr[(i+k)%n]=nums[i];

//         }
//         for(int i=0;i<n;i++){
//             nums[i]=arr[i];
//         }
//     }
// }
public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;

        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int nextIdx = (current + k) % n;
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                current = nextIdx;
                count++;
            } while (start != current);
        }
    }
}