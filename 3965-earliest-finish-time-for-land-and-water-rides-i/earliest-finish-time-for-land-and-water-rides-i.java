class Solution {
    public int earliestFinishTime(int[] startl, int[] durl, int[] startw, int[] durw) {

        int minl = 3000, minw = minl, res = minw;
        int n = startl.length;
        int m = startw.length;

        for (int i = 0; i < n; i++)
            minl = Math.min(minl, startl[i] + durl[i]);

        for (int i = 0; i < m; i++) {
            minw = Math.min(minw, startw[i] + durw[i]);
            res = Math.min(res, Math.max(minl, startw[i]) + durw[i]);
        }

        for (int i = 0; i < n; i++)
            res = Math.min(res, Math.max(minw, startl[i]) + durl[i]);

        return res; 
    }
}