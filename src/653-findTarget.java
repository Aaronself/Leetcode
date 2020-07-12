import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    private int index = 0;

    public boolean findTarget(TreeNode root, int k){
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) 
            return false;
        travel(root, list);
        for (int i = 0; i < map.size(); i++) {
            int x = list.get(i);
            if (map.get(k - x) != null && map.get(k - x) != i)
                return true;
        }
        return false;
    }
    
    private void travel(TreeNode root, List<Integer> list) {
        if(root == null)
            return;

        map.put(root.val, index);
        index += 1;
        list.add(root.val);
        travel(root.left, list);
        travel(root.right, list);
        return;
    }
}