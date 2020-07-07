import java.util.List;
import java.util.Queue;

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode popNode;

        while(!queue.isEmpty()){
            popNode = queue.poll();
            if(popNode != null){
                list.add(popNode.val);
                queue.offer(popNode.left);
                queue.offer(popNode.right);
            }
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++)
            res[i] = list.get(i);
        return res;
    }
}