import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    List<Integer> res = new ArrayList<Integer>();
    public int sumEvenGrandparent(TreeNode root) {
        if (root == null) return 0;
        travel(root);
        int sum = 0;
        for (int i = 0; i < res.size(); i++){
            sum += res.get(i);
        }

        return sum;
    }

    private void travel(TreeNode node) {
        if (node == null)
            return;
        
        if (node.val % 2 == 0){
            childNode(node.left);
            childNode(node.right);
        }
        travel(node.left);
        travel(node.right);
        return;
    }

    private void childNode(TreeNode root) {
        if (root == null)
            return;
        
        if (root.left != null)
            res.add(root.left.val);
        if (root.right != null)
            res.add(root.right.val);

        return;
    }
}  