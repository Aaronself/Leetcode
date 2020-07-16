class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return t == null;

        return compare(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean compare(TreeNode node, TreeNode t) {
        if (node == null && t == null) { return true; }
        if (node == null || t == null) { return false; }

        return node.val == t.val && compare(node.left, t.left) && compare(node.right, t.right);
    }
}