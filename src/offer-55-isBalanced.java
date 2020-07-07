public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean balancedFlag = true;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return false;
        
        height(root);
        return balancedFlag;
    }

    private int height(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1)
            balancedFlag = false;
        
        return (leftHeight > rightHeight)? leftHeight + 1 : rightHeight + 1;
    }
}