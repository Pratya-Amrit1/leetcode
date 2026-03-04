class Solution {
    public class Pair {
        int profit;
        int cap;

        public Pair(int profit, int cap) {
            this.profit = profit;
            this.cap = cap;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(profits[i], capital[i]);
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.cap == b.cap) {
                return b.profit - a.profit;
            }
            return a.cap - b.cap;
        });

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.profit - o1.profit;
            }
        });

        int i = 0;
        while (i < n && arr[i].cap <= w) {
            pq.add(new Pair(arr[i].profit, arr[i].cap));
            i++;
        }
        while (!pq.isEmpty() && k != 0) {
            Pair rv = pq.poll();
            w += rv.profit;
            while (i < n && arr[i].cap <= w) {
                pq.add(new Pair(arr[i].profit, arr[i].cap));
                i++;
            }
            k--;
        }
        return w;
    }
}