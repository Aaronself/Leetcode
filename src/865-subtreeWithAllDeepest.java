class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    class HeightNode {
        int height;
        TreeNode node;

        HeightNode(int x, TreeNode root) { height = x; node = root;}
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    
    private HeightNode dfs(TreeNode root) {
        if (root == null) return new HeightNode(0, null);
        HeightNode left = dfs(root.left);
        HeightNode right = dfs(root.right);
        if(left.height > right.height) return new HeightNode(left.height + 1, left.node);
        if(left.height < right.height) return new HeightNode(right.height + 1, right.node);
        return new HeightNode(left.height + 1, root);
    }
}