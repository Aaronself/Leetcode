import java.util.List;

import javax.lang.model.util.ElementScanner6;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        List<Coordinate> list = new ArrayList<Coordinate>();
        inOrderTravel(root, 0, 0, list);
        Collections.sort(list);

        int prev = list.get(0).xaxis;
        res.add(new ArrayList<Integer>());
        for (Coordinate a : list) {
            if (a.xaxis != prev) {
                prev = a.xaxis;
                res.add(new ArrayList<Integer>());
            }
            res.get(res.size()-1).add(a.val);
        }

        return res;
    }

    private void inOrderTravel(TreeNode root, int x, int y, List<Coordinate> list) {
        if (root == null)
            return;

        Coordinate node = new Coordinate(root.val, x, y);
        list.add(node);
        inOrderTravel(root.left, x - 1, y + 1, list);
        inOrderTravel(root.right, x + 1, y + 1, list);
        return;
    }
}

class Coordinate implements Comparable<Coordinate>{
        int val, xaxis, yaxis;
        Coordinate(int x, int y, int z) {
            this.val = x;
            this.xaxis = y;
            this.yaxis = z;
        }
    
    public int compareTo(Coordinate that){
        if (this.xaxis != that.xaxis)
            return Integer.compare(this.xaxis, that.xaxis);
        else if (this.yaxis != that.yaxis)
            return Integer.compare(this.yaxis, that.yaxis);
        else
            return Integer.compare(this.val, that.val);
    }
}