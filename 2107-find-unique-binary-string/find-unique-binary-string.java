class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String s="";
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i)=='0'){
                s=s+'1';
            }
            else{
                s=s+'0';
            }
        }
        return s;
    }
}