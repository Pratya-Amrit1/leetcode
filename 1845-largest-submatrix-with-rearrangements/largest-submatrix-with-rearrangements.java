class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i =1; i< m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j]==0) continue;
                matrix[i][j] += matrix[i-1][j];
            }
        }
        int maxArea = 0;
        for(int i=0; i<m; i++) {
            Arrays.sort(matrix[i]);
            for(int j=0; j<n; j++) {
                int width = n-j;
                maxArea = Math.max(maxArea, width * matrix[i][j]);
                
            }
        }
        return maxArea;
    }
}