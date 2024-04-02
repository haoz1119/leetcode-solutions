/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        // if the node is null, we return an empty arraylist, 
        // with addAll, the empty arraylist will have no effect
        if(root == null) return new ArrayList<Integer>();
        ls.add(root.val);
        ls.addAll(preorderTraversal(root.left));
        ls.addAll(preorderTraversal(root.right));
        return ls;
    }
}
// @lc code=end

