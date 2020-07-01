import java.util.HashMap;

class Solution {
    public  String longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            Character alpha = s.charAt(i);
            if(map.containsKey(alpha)){
                int left = map.get(alpha);
            }

        }
    }
}