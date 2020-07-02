class Solution {
    public int romanToInt(String s) {
        StringBuilder alpha = new StringBuilder();
        alpha.append(s);
        int sum = 0;
        int num = 0;
        int lastNum = 0;
        for (int i = 0; i < alpha.length(); i++){
            num = getValue(alpha.charAt(i));
            if(i != alpha.length() - 1)
                lastNum = getValue(alpha.charAt(i+1));
            if(num >= lastNum)
                sum = sum + num;
            else
                sum = sum - num;
        }
        return sum;
    }

    private int getValue(Character s){
        switch (s){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
            default : return 0;
        }
            
    }
}