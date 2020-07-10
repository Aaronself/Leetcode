import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val=x; }
}

class Solution {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
     
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;

        List<Integer> list = new ArrayList<Integer>();
        backtrace(root, list, sum);
        return res;
    }

    private void backtrace(TreeNode root, List<Integer> list, int target){
        if(root == null)
            return;
        
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(list));//复制一个list进入res的空间，否则对于list的修改会改变这里的
        } else {
            backtrace(root.left, list, target);
            backtrace(root.right, list, target);
        }

        list.remove(list.size() - 1);
        return;
    }
}