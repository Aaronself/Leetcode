/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * 递归的方式完成，树由左子树和右子树拼接而成，递归的要点在
 * 1. 何时递归结束
 * 2. 创建递归的根节点
 * 3. 合并
 */
import java.util.HashMap;
import java.util.Map;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;

        Map<Integer, Integer> prePositionMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < preorder.length; i++)
            prePositionMap.put(inorder[i], i);
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, prePositionMap);

        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preStop, int[] inorder, int inStart, int inStop, Map<Integer, Integer> indexMap){
        if(preStart > preStop)
            return null;
        
        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);
        if(preStart == preStop)
            return node;
        else{
            int rootIndex = indexMap.get(val);
            int leftSubTreeLen = rootIndex - inStart;
            int rightSubTreeLen = inStop - rootIndex;
            TreeNode leftSubTree = buildTree(preorder, preStart + 1, preStart + leftSubTreeLen, inorder, inStart, inStart + leftSubTreeLen - 1, indexMap);
            TreeNode rightSubTree = buildTree(preorder, preStop - rightSubTreeLen + 1, preStop, inorder, rootIndex + 1, inStop, indexMap);
            node.left = leftSubTree;
            node.right = rightSubTree;
            return node;
        }
    }
}