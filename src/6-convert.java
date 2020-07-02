package convert;

import java.util.ArrayList;
import java.util.List;

class Solution{

    public String convert(String s, int numRows) {
        if(s == "" || s.length() == 0)
            return "";
        
        if (numRows < 2)
            return s;
        
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) 
            rows.add(new StringBuilder());
        for (int i = 0; i < s.length(); i++){
            Character alpha = s.charAt(i);
            int row = 0;
            if(i % (2 * numRows - 2) >= numRows){
                row = 2 * numRows - 2 - (i % (2 * numRows - 2));
            }
            else
                row = i % (2 * numRows - 2);
            rows.get(row).append(alpha);
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    } 
}