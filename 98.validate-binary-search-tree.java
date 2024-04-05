/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
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

// to solve this kind of tree problems, try to ask if you can look at a tree diagram and solve it
class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root.left,Long.MIN_VALUE,root.val)&&helper(root.right,root.val, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long lb, long rb){
        if(root == null) return true;
        if(root.val <= lb || root.val >= rb) return false;
        else return helper(root.left, lb, root.val) && helper(root.right, root.val, rb);
    }
}
// @lc code=end

