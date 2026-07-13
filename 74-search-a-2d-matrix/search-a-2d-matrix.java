class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //staircase
        int n=matrix.length;
        int m=matrix[0].length;
        int low=0;
        int high= n*m-1;
        while(low<=high){
            int mid=(low+high)/2;
            int r=mid/m;
            int c=mid%m;
            if(target== matrix[r][c])return true;
            else if(target<=matrix[r][c]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return false;
        
        // //brute force
        // for(int i=0;i<matrix.length;i++){
        //     for(int j=0;j<matrix[0].length;j++){
        //         if(matrix[i][j]==target){
        //             return true;
        //         }
        //     }
        // }
        // return false;
        
    }
}