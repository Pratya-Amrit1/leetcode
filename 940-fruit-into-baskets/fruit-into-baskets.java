class Solution {
    public int totalFruit(int[] fruits) {
        //brute force tle
        // int maxlength=0;
        // for(int i=0;i<fruits.length ;i++){
        //     Set<Integer> set = new HashSet<>();
        //     for(int j=i;j<fruits.length ;j++){
        //         set.add(fruits[j]);
        //         if(set.size()<=2){
        //             maxlength= Math.max(maxlength ,j-i+1);

        //         }
        //         else{
        //             break;
        //         }
        //     }
        // }
        // return maxlength;
        int l =0 , r= 0 , maxlen =0;
        Map<Integer ,Integer> mpp = new HashMap<>();
        while(r<=fruits.length-1){
            
            mpp.put(fruits[r], mpp.getOrDefault(fruits[r],0)+1);
            if(mpp.size()>2){
            
                mpp.put(fruits[l] ,mpp.get(fruits[l]) -1);
                if(mpp.get(fruits[l])==0){
                    mpp.remove(fruits[l]);
                }
            
                    l++;
            }
            if(mpp.size()<=2){
                maxlen = Math.max(maxlen, r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}