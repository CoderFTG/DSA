class Solution {
    public long numOfSubsequences(String s) {
        int n = s.length();
        long[] preL = new long[n + 2];
        long[] preLC = new long[n + 2];
        
        long l = 0, lc = 0, countLCT = 0;

        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == 'L') {
                l++;
            } else if (ch == 'C') {
                lc += l;
            } else if (ch == 'T') {
                countLCT += lc;
            }
            preL[i + 1] = l;
            preLC[i + 1] = lc;
        }

        long[] sufT = new long[n + 5];
        long[] sufCT = new long[n + 5];
        long t = 0, ct = 0;

        for (int i = n - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (ch == 'T') {
                t++;
            } else if (ch == 'C') {
                ct += t;
            }
            sufT[i + 1] = t;
            sufCT[i + 1] = ct;
        }

        long answer1 = sufCT[1] + countLCT;    // insert 'L' at beginning
        long answer2 = preLC[n] + countLCT;    // insert 'T' at end

        
        long answer3 = 0;
        for (int i = 1; i <= n; ++i) {
            answer3 = Math.max(answer3, preL[i] * sufT[i + 1]);
        }

        return Math.max(answer1, Math.max(answer2, answer3 + countLCT));
    }
}