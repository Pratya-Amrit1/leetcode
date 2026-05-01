class Solution {
    public int[] searchRange(int[] nums, int target) {
 
        return new int[] {first(nums, target )  , last(nums , target)};
    }
    private int first(int [] arr , int target){
 
        int left = 0 ; 
        int right = arr.length -1; 
        int ans = -1;

        while(left<=right){
            int mid = left + (right - left) / 2;

            
            
            if(arr[mid] == target ){

                ans = mid;
                right = mid - 1;
            }
            else if (arr[mid]<target){
                left = mid + 1; 
            }
            else{
                right = mid -1 ; 
            }
        }
        return ans ; 

    }


    private int last (int [] arr , int target){
        int left = 0; 
        int right = arr.length-1;
        int ans = -1;

        while(left <= right ){
            int mid = left + (right - left )/2; 

            if (arr[mid] == target ){
                ans = mid ;
                left = mid+1 ; 
            }
            else if (arr[mid]>target ){
                right = mid -1;
            }else{
                left = mid + 1; 
            }
        }
        return ans ;
    }
}