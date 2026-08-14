class Solution {
    public int longestConsecutive(int[] a) {
        Map<Integer, Boolean> present = new HashMap<>();
        Map<Integer, Boolean> checked = new HashMap<>();
        int longestConsecutiveChain = 0;

        for(int i = 0; i < a.length; i++) {
            present.put(a[i], true);
        }

        for(int i = 0; i < a.length; i++) {
            if(!checked.getOrDefault(a[i], false) && !present.containsKey(a[i] - 1)) {
                int currentChain = 0;
                int start = a[i];

                while(present.containsKey(start)) {
                    currentChain++;
                    checked.put(start, true);
                    start++;
                }

                longestConsecutiveChain = Math.max(currentChain, longestConsecutiveChain);
            }
        }
    
        return longestConsecutiveChain;
    }
}
