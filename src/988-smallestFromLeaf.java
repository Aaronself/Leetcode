import java.util.List;

import sun.net.www.protocol.http.HttpURLConnection.TunnelState;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean list_flag = false;
    public String smallestFromLeaf(TreeNode root) {
        List<Integer> smallList = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode pre = root;
        while (pre != null) {
            smallList.add(pre.val);
            if(pre.left != null)
                pre = pre.left;
            else
                pre = pre.right;
        }
        findSmallest(root, smallList, list);

        String A = new String();
        for (int i = smallList.size() - 1; i >= 0; i--) {
            char C = (char) (smallList.get(i) + 97);
            A += C;
        }
        
        return A;
    }

    private void findSmallest(TreeNode root, List<Integer> smallList, List<Integer> list) {
        if (root == null)
            return;

        list.add(root.val);
        findSmallest(root.left, smallList, list);
        findSmallest(root.right, smallList, list);
        if (root.left == null && root.right == null) {
            compare(smallList, list);
            if (list_flag == true) {
                list_flag = false;
                smallList.clear();
                for (int a : list)
                    smallList.add(a);
            }
        }
        list.remove(list.size() - 1);
    }
    
    private void compare(List<Integer> smallList, List<Integer> list) {
        boolean same_flag = true;
        int i = list.size() - 1;
        int j = smallList.size() - 1; 

        for (; i >= 0 && j >= 0; i--, j--) {
            if (list.get(i) < smallList.get(j)) {
                same_flag = false;
                list_flag = true;
                return;
            } else if (list.get(i) > smallList.get(j)) {
                same_flag = false;
                return;
            }
        }
        
        if (same_flag == true) {
            if(list.size() < smallList.size())
                list_flag = true;
        }
    }
}