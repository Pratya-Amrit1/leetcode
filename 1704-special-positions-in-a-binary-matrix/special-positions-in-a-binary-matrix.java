class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;         
        int n = mat[0].length;      
        int count = 0;               

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    boolean special = true;   
                    for (int col = 0; col < n; col++) {
                        if (col != j && mat[i][col] == 1) {
                            special = false;  
                            break;
                        }
                    }
                    if (special) {
                        for (int row = 0; row < m; row++) {
                            if (row != i && mat[row][j] == 1) {
                                special = false;   
                                break;
                            }
                        }
                    }
                    if (special) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}