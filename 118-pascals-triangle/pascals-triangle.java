class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                // Every cell in Pascal's triangle is exactly nCr!
                row.add(nCr(i, j));
            }
            triangle.add(row);
        }
        return triangle;
    }
    
    // Helper function to calculate combinations (n choose r)
    private int nCr(int n, int r) {
        long res = 1;
        // Optimize by taking the smaller half
        if (r > n - r) r = n - r; 
        
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return (int) res;
    }
}
