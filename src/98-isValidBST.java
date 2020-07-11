import javax.lang.model.util.ElementScanner6;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i-1) >= list.get(i))
                return false;
        }
        return true;
    }
    
    private void inOrderTravel(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        inOrderTravel(root.left, list);
        list.add(root.val);
        inOrderTravel(root.right, list);
        return;
    }
}