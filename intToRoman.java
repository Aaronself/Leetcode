class Solution {
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    private final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        StringBuilder alpha = new StringBuilder();
        while(num > 0){
            for(int i = 0; i < values.length; i++){
                if (num - values[i] >= 0){
                    alpha.append(symbols[i]);
                    num = num - values[i];
                    break;
                }
            }
        }
        return alpha.toString();
    }
}