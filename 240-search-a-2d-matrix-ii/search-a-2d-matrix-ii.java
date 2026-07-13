class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix[0].length;
        int n=matrix.length;
        int row=0;
        int col=m-1;
        while(row<n && col>=0){
            if(target==matrix[row][col])return true;
            else if(target>=matrix[row][col]){
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}