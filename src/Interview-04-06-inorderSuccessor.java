import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        inOrderTravel(root, list);
        for (int i = 0; i < list.size(); i++) {
            if (p == list.get(i)) {
                if (i != list.size() - 1)
                    return list.get(i + 1);
            }
        }
        return null;
    }

    private void inOrderTravel(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        
        inOrderTravel(root.left, list);
        list.add(root);
        inOrderTravel(root.right, list);
        return;
    }
}