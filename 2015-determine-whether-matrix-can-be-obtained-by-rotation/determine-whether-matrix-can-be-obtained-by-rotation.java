class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
     for(int  i = 0; i < 4; i++){
        if(isEqual(mat, target)){
            return true;
        }
        rotate(mat);
     }   
     return false;
    }
    private void rotate(int[][] mat){
        int n = mat.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++){
            int temp = mat[i][j];
            mat[i][j] = mat[j][i];
            mat[j][i] = temp;
        }
    }
    for(int i = 0; i < n; i++){
        int left = 0, right = n - 1;
        while(left < right){
            int temp = mat[i][left];
            mat[i][left] = mat[i][right];
            mat[i][right] = temp;
            left++;
            right--;
        }
    }
}
private boolean isEqual(int[][] mat, int[][] target){
    int n = mat.length;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(mat[i][j] != target[i][j]){
                return false;
            }
        }
    }
    return true;
  }
}