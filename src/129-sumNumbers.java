class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public int sumNumbers(TreeNode root) {
        return bfs(root, 0);
    }

    private int bfs(TreeNode root, int prev) {
        if(root == null)
            return 0;
        int sum = root.val + prev * 10;
        if(root.left == null && root.right == null)
            return sum;

        return bfs(root.left, sum) + bfs(root.right, sum);
    }
}