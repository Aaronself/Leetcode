class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return preOrderTravel(p, q);
    }

    private boolean preOrderTravel(TreeNode p, TreeNode q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return ((p.val == q.val) && (preOrderTravel(p.left, q.left) && preOrderTravel(p.right, q.right)));        
    }
}