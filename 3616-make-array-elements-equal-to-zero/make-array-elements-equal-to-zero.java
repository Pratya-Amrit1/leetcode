class Solution {
    public int countValidSelections(int[] nums) {

        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1]= sum[i] + nums[i];
        }

        int count = 0;
        for (int i = 0; i< nums.length; i++) {
            if(nums[i] == 0) {
                if(sum[i] == sum[nums.length] - sum[i]) {
                    count += 2;
                } 
                // if(sum[i] == sum[nums.length] - sum[i] + 1) {
                //     count++;
                // }
                // if(sum[i] + 1 == sum[nums.length] - sum[i]) {
                //     count++;
                // }

                // refactoring the above lines
                if(Math.abs(sum[nums.length] - 2*sum[i]) == 1) count++;
            } 
        }
        return count;
    }
}