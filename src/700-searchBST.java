class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return preOrderTravel(root, val);
    }

    private TreeNode preOrderTravel(TreeNode root, int val){
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        if(root.val > val)
            return preOrderTravel(root.left, val);
        else
            return preOrderTravel(root.right, val);
    }
}