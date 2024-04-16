/*
 * @lc app=leetcode id=623 lang=java
 *
 * [623] Add One Row to Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(root == null) return new TreeNode(val);
        if(depth == 1) return new TreeNode(val, root, null);
        add(root, val, 1, depth);
        return root;
    }
    public void add(TreeNode root, int val, int curd, int depth){
        if(root == null && curd < depth) return;
        if(root != null && curd == depth - 1){
            root.left = new TreeNode(val, root.left, null);
            root.right = new TreeNode(val, null, root.right);
        }
        else if(root != null && curd < depth - 1){
            add(root.left, val, curd+1, depth);
            add(root.right, val, curd+1, depth);
        }
    }
}
// @lc code=end

