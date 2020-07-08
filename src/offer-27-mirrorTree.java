import java.util.Stack;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode mirrorTree(TreeNode root){
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node;
        stack.push(root);
        while(!stack.isEmpty()){
            node = stack.pop();
            if(node.left != null) stack.push(node.left);
            if(node.right != null) stack.push(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }

        return root;
    }
}