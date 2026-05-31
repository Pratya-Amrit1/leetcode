class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long current = mass;
        for (int aster : asteroids) {
            if (current < aster) {
                return false;
            }
            current += aster;
        }

        return true;
    }
}