import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        Map<Integer ,Integer> mpp =new HashMap<>();
        List<Integer> ap = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(mpp.containsKey(nums[i])){
                ap.add(nums[i]);
            }
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        int[] ans = new int[ap.size()];

for (int i = 0; i < ap.size(); i++) {
    ans[i] = ap.get(i);   
}
        return ans;

    }
}