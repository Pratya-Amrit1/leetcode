class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] newarr = nums1;
        int minodd = Integer.MAX_VALUE;
        int mineven = Integer.MAX_VALUE;
        boolean hasodd=false ,haseven=false;
        for(int num:newarr){
            if(num%2==0){
                haseven=true;
                
            }
            else{
                hasodd=true;
                minodd= Math.min(minodd,num);
            }
        }
        if(!hasodd || !haseven)return true;
        for(int num:newarr){
            if(num%2==0){
                if(num<=minodd){
                    return false;
                }
            }
        }
        return true;
    }
}