public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int maxDepth(TreeNode root){
        return depth(root) + 1;
    }
    private int depth(TreeNode root){
        if(root == null)    
            return 0;

        int left = depth(root.left);
        int right = depth(root.right);

        return (left > right) ? left + 1 : right + 1;
    }
}