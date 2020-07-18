class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    private int second = Integer.MAX_VALUE;
    private boolean change = false;
    public int findSecondMinimumValue(TreeNode root) {
        travel(root, root.val);
        if (change != true)
            return -1;
        else
            return second;
    }
    
    private void travel(TreeNode root, int smallest) {
        if (root == null)
            return;
        if (root.val > smallest) {
            if (root.val <= second){
                second = root.val;
                change = true;
            }
            return;
        }
        travel(root.left, smallest);
        travel(root.right, smallest);
    }
}