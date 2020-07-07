import java.util.ArrayList;

public class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class Solution{
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new List<Integer>();
        inorder(list, root);

        return list;
    }
    
    private void inorder(List<Integer> list, TreeNode A){
        if (A == null)
            return;
        
        inorder(list, A.left);
        list.add(A.val);
        inorder(list, A.right);
    }
}