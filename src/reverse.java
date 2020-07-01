class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int num = x % 10;
            ans = ans * 10 + num;
            System.out.println(ans);
            if(x / 10 != 0 && (ans >= 214748365 || ans <= -214748365))
                return 0;
            x = x / 10;
        }

        return ans;
    }
}