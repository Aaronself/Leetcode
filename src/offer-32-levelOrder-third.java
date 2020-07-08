import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        boolean left2right = true;
        int curNum = 1;
        int nextNum = 0;
        TreeNode pollNode;
        queue.offer(root);

        while(queue.size() != 0){
            pollNode = queue.poll();
            curNum -= 1;
            if(curNum == 0){
                curNum = x;
                left2right = (left2right == true)? false : true;
            }
            list.add(pollNode.val);
            if(pollNode != null){
                queue.offer(pollNode.left);
                queue.offer(pollNode.right);
                nextNum += 2;
            }
        }
    }
}