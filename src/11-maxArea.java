import javax.swing.text.AbstractDocument.LeafElement;

class Solution{
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int length = height.length - 1;
        int area = Math.min(height[left], height[right]) * length;
        while(left < right){
            if(height[left] < height[right]){
                left = left + 1;
            }else{
                right = right - 1;
            }
            length = length - 1;
            if (Math.min(height[left], height[right]) * length > area)
                area = Math.min(height[left], height[right]) * length;
        }

        return area;
    }
}