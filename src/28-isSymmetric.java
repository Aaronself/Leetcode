public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return judge(root.left, root.right);
    }

    private boolean judge(TreeNode left, TreeNode right){
        if(left == null && right != null)
            return false;
        else if(left != null && right == null)
            return false;
        else if(left == null && right == null)
            return true;
        if(left.val != right.val)
            return false;
        
        
        return judge(left.left, right.right) && judge(left.right, right.left);
    }
}