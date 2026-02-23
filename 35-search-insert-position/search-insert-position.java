class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        while( i< nums.length){
            if(target==nums[i]){
                return i;
            }
            else if(target<nums[i]){
                return i;
            }
            i++;
        }
        return i;
    }
}

// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         int l = 0, r = nums.length-1;
//         while (l <= r){
//             int mid = l + (r - l)/2;
//             if (nums[mid] == target) return mid;
//             else if (nums[mid] < target) l = mid + 1;
//             else r = mid - 1;
//         }
//         return  l;
//     }
// }