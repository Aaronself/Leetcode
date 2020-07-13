import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    public int sumRootToLeaf(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        backTrace(root, list);
        int sumOfRes = 0;
        for (int i = 0; i < res.size(); i++) {
            List<Integer> ans = res.get(i);
            int sumOfList = 0;
            for (int j = 0; j < ans.size(); j++) {
                sumOfList = sumOfList * 2 + ans.get(j);
            }
            sumOfRes += sumOfList;
        }
        return sumOfRes;
    }

    private void backTrace(TreeNode root, List<Integer> list){
        if(root == null)
            return;
        
        list.add(root.val);
        if(root.left == null && root.right == null)
            res.add(new ArrayList(list));
        else {
            backTrace(root.left, list);
            backTrace(root.right, list);
        }
        
        list.remove(list.size() - 1);
        return;
    }
}