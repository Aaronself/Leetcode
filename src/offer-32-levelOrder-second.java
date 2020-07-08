import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(root != null)
            queue.offer(root);
        TreeNode popNode;

        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = size; i > 0; i--){
                popNode = queue.poll();
                list.add(popNode.val);
                if(popNode.left != null) queue.offer(popNode.left);
                if(popNode.right != null) queue.offer(popNode.right);
            }
            res.add(list);
        }
        return res;
    }
}