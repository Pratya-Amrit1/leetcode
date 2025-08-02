class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows==0){
            return triangle;
        }
        triangle.add(Arrays.asList(1));
        for(int i=1;i<numRows ;i++){
             List<Integer> rows=new ArrayList<>();
             List<Integer> prev= triangle.get(i-1);
             rows.add(1);
             for(int j=1 ;j<i;j++){
                rows.add(prev.get(j-1)+ prev.get(j));
             }
             rows.add(1);
             triangle.add(rows);
                     }
                     return triangle;
    }
}