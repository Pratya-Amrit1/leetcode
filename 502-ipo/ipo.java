class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        IPO[] sortedArr = new IPO[capital.length];
        for(int i=0; i<profits.length; i++)
        {
            sortedArr[i] = new IPO(profits[i],capital[i]);
        }
        Arrays.sort(sortedArr,(a,b) -> Integer.compare(a.capital,b.capital));
        int j=0;
        for(int i=0; i<k; i++)
        {
            while(j < profits.length && sortedArr[j].capital <= w)
            {
                pq.offer(sortedArr[j].profit);
                j++;
            }

            if(pq.isEmpty()) break;
            w += pq.poll();
        }
        return w;
    }
}

public class IPO{
    int profit;
    int capital;
    public IPO(int profit,int capital)
    {
        this.profit = profit;
        this.capital = capital;
    }
}