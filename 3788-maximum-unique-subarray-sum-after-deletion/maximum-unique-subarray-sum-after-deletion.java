class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer> seter = new HashSet<>();
        for(int n:nums) seter.add(n);
        int result=0;

        for(int n : seter){
            if(n>0) result+=n;
        }
        if(result==0){
            result= Collections.max(seter);
        }
        return result;
    }
}