class Solution {
    public int strStr(String haystack, String needle) {
        int haystack_len = haystack.length();
        int needle_len = needle.length();
        if (needle_len == 0)
            return 0;
        if (haystack_len == 0)
            return -1;

        int[][] dp = new int[needle_len][256];
        int shadow_state = 0;
        int x = 0;
        
        dp[0][needle.charAt(0)] = 1;

        for (int i=1; i<needle_len; i++){
            for (int c=0; c<256; c++){
                if (needle.charAt(i) == c)
                    dp[i][c] = i+1;
                else
                    dp[i][c] = dp[shadow_state][c];
            }
            shadow_state = dp[shadow_state][needle.charAt(i)];
        }
        
        int j = 0;
        for (int i=0; i<haystack_len; i++){
            j = dp[j][haystack.charAt(i)];
            if (j == needle_len)
                return i-needle_len+1;
        }
        return -1;
    }
}