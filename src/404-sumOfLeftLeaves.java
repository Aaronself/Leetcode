class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        travel(null, root);
        return sum;
    }
    
    private void travel(TreeNode fatherNode, TreeNode root) {
        if (root == null)
            return;
        if (fatherNode == null)
            sum += 0;
        else if(fatherNode.left == root && root.left == null && root.right == null)
            sum += root.val;
        
        travel(root, root.left);
        travel(root, root.right);
        return;
    }
}