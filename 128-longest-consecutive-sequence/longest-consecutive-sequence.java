class Solution {
    public int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        // int count =1;
        // int max=1;
        // if(nums.length==0){
        //     return 0;
        // }
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i]+1 == nums[i+1]){
        //         count++;
        //         max= Math.max(count, max);
        //     }
        //     else if( nums[i]== nums[i+1]){
        //         continue;
        //     }
        //     else{
        //         count=1;
        //     }
        // }
        // return max;

        int n = nums.length;
        if(n == 0) return 0;
        int longest = 1;

        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<n; i++) {
            set.add(nums[i]);
        }

        for(int num : set) {
            if(!set.contains(num-1)) {
                int count = 1;
                int x = num;

                while(set.contains(x+1)) {
                    count = count + 1;
                    x = x + 1;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}