/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null)
            return false;
        
        return preOrderRecur(A, B);
    }

    private boolean preOrderRecur(TreeNode A, TreeNode B){
        if(A == null)
            return false;
        if(A.val == B.val){
            if(isEqual(A, B))
                return true;
        }
        return preOrderRecur(A.left, B) || preOrderRecur(A.right, B);
    }

    private boolean isEqual(TreeNode A, TreeNode B){
        if(B == null)
            return true;
        if(A == null)
            return false;
        if(A.val != B.val)
            return false;

        boolean flag = isEqual(A.left, B.left) && isEqual(A.right, B.right);
        return flag;
    }
}