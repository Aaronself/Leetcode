class Solution:
    def longestPalindrome(self, s: str) -> str:
        str_len = len(s)
        if str_len == 1:
            return s
        relt = ""

        def find_str(i: int, j: int) -> str:
            while(i >= 0 and j <= str_len-1 and s[i] == s[j]):
                i -= 1
                j += 1
            return s[i+1:j]
        
        for i in range(len(s)-1):
            # 处理回文子串可能是奇数或者偶数的情况
            s1 = find_str(i, i)
            s2 = find_str(i, i+1)
            if len(s1) > len(s2):
                relt = relt if len(relt) > len(s1) else s1
            else:
                relt = relt if len(relt) > len(s2) else s2
        
        return relt
        