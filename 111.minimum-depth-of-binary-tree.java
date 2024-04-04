/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int minleft = 0, minright = 0;
        if(root.left == null && root.right == null){
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        else if(root.left != null && root.right == null)  {
            minleft = minDepth(root.left);
            return 1 + minleft;
        }
        else if(root.right!=null && root.left == null) {
            minright = minDepth(root.right);
            return 1 + minright;
        }
        else{
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
        
    }
}
// @lc code=end

