class Solution {
    public int minStoneSum(final int[] piles, int k) {
        final Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        int total = 0;

        for(final int pile : piles) {
            total += pile;

            maxHeap.offer(pile);
        }

        while(k-- > 0) {
            int pile = maxHeap.poll();

            total -= pile;

            pile = (pile + 1) / 2;

            total += pile;
            maxHeap.offer(pile);
        }

        return total;
    }
}