class Solution {
    int maxind(int[][] mat , int n, int m, int col){
        int maxval=-1;
        int index=-1;
        for(int i=0;i<n;i++){
            if(maxval<mat[i][col]){
                maxval=mat[i][col];
                index=i;
            }
        }
        return index;
    }
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int low=0;
        int high=m-1;
        while(low<=high){
            int mid=(low+high) /2;
            int maxrow=maxind(mat , n, m, mid);
            int left=mid-1 >=0 ? mat[maxrow][mid-1]:-1;
            int right=mid+1 <m ? mat[maxrow][mid+1] : -1;
            if(mat[maxrow][mid]>left && mat[maxrow][mid]>right){
                return new int[] {maxrow,mid};
            }
            else if(mat[maxrow][mid]<left){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
    }
        return new int[] {-1,-1};
}}