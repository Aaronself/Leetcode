import javax.sound.sampled.SourceDataLine;

class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;

        String s = String.valueOf(x);
        int left = 0;
        int right = s.length() - 1;
        for (;left < right;){
            char a = s.charAt(left);
            char b = s.charAt(right);
            if(a != b)
                return false;
            left = left + 1;
            right = right - 1;
        }
        return true;
    }
}