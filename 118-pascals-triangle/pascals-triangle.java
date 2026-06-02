class Solution {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> pas = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));
            
            for (int j = 1; j < i; j++) {
                int val = pas.get(i - 1).get(j - 1) + pas.get(i - 1).get(j);
                row.set(j, val);
            }
            pas.add(row);
        }
        return pas;
    }
}