class Solution {
    public long countStableSubarrays(int[] c) {
        Map<String, Long> g = new HashMap<>();
        long sum = 0;
        long u = 0;

        for (int i = 0; i < c.length; i++) {
            sum += c[i];
            long desiredSum = sum - 2L * c[i];

            String keyDesired = desiredSum + "," + c[i];
            if (g.containsKey(keyDesired)) {
                u += g.get(keyDesired);
            }

            String keyCurrent = sum + "," + c[i];
            g.put(keyCurrent, g.getOrDefault(keyCurrent, 0L) + 1);
        }

        int d = c.length;
        for (int i = 0; i < d - 1; i++) {
            // Subarrays of size 2 of type [0,0] got overcounted
            if (c[i] == 0 && c[i + 1] == 0) {
                u--;
            }
        }

        return u;
    }
}