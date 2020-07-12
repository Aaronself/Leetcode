class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) 
            return false;
        return travel(root.left, root.val) && travel(root.right, root.val);
    }
    
    private boolean travel(TreeNode root, int prev) {
        if(root == null)
            return true;
        if (root.val != prev)
            return false;
        
        return travel(root.left, prev) && travel(root.right, prev);
    }
}

/** another way
 * 
 * class Solution {
    public boolean isUnivalTree(TreeNode root) {
        if(root == null) 
            return false;
        List<Integer> list = new ArrayList<Integer>();
        travel(root, list);
        int prev = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != prev)
                return false;
        }
        return true;
    }
    
    private void travel(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        list.add(root.val);
        travel(root.left, list);
        travel(root.right, list);
        return;
    }
}
 */