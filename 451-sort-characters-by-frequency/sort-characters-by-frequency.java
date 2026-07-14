class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<List<Character>> bucket = new ArrayList<>();

        for (int i = 0; i <= s.length(); i++) {
            bucket.add(new ArrayList<>());
        }
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            bucket.get(entry.getValue()).add(entry.getKey());
        }
        StringBuilder sb = new StringBuilder();

        for (int freq = s.length(); freq >= 1; freq--) {

            for (char c : bucket.get(freq)) {

                for (int count = 0; count < freq; count++) {
                    sb.append(c);
                }

            }
        }

        return sb.toString();
    }
}