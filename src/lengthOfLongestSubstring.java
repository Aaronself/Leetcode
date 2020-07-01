import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int lastLength = 0;
        int ans = 0;
        int left = 0;
        for(int right = 0; right < s.length(); right = right + 1){
            char alpha = s.charAt(right);
            if(map.containsKey(alpha)){
                ans = Math.max(right - left, lastLength);
                lastLength = ans;
                left = Math.max(map.get(alpha) + 1, left);
                map.remove(alpha);
            }
            if(right == s.length() - 1){
                ans = Math.max(right - left + 1, lastLength);
            }
            map.put(alpha, right);
        }
        return ans;
    }
}