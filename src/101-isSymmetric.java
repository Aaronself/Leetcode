class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return search(root.left, root.right);
    }
    
    private boolean search(TreeNode lnode, TreeNode rnode) {
        if (lnode == null && rnode == null)
            return true;
        else if ((lnode == null && rnode != null) || (lnode != null && rnode == null))
            return false;
        if(lnode.val != rnode.val)
            return false;
        
        return search(lnode.left, rnode.right) && search(lnode.right, rnode.left);
    }
}