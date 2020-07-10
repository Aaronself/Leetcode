class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    // public TreeNode res;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     travel(root, p, q);

    //     return res;
    // }

    // private void travel(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == null)
    //         return;
    //     if ((p.val < root.val && root.val < q.val) || (p.val > root.val && root.val > q.val)) {
    //         res = root;
    //         return;
    //     }
    //     if (p == root || q == root) {
    //         res = root;
    //         return;
    //     }
    //     if(p.val < root.val)
    //         travel(root.left, p, q);
    //     else if(p.val > root.val)
    //         travel(root.right, p, q);
    // }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && root.val < q.val)
            return lowestCommonAncestor(root.left, p, q);
        if (p.val > root.val && root.val > q.val)
            return lowestCommonAncestor(root.right, p, q);
        return root;
    }
}