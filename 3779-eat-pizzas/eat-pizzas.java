class Solution {
    public long maxWeight(final int[] pizzas) {
        Arrays.sort(pizzas);

        final int n = pizzas.length;
        int m = n / 4;
        int z = (m + 1) / 2;
        int y = m / 2;
    
        int j = 0;
        long weight = 0;

        for(int i = 0; i < z; ++i)
            weight += pizzas[n - 1 - j++];

        for(int i = 0; i < y; ++i) {
            weight += pizzas[n - 1 - j - 1];
            j += 2;
        }

        return weight;
    }
}