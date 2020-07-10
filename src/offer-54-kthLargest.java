import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val=x; }
}

class Solution {
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<Integer>();
        travels(root, list);
        Collections.sort(list, Collections.reverseOrder());
        
        return list.get(k - 1);
    }

    private void travels(TreeNode root, List<Integer> list) {
        if(root == null)
            return;
        list.add(root.val);
        travels(root.left, list);
        travels(root.right, list);
        
        return;
    }
}