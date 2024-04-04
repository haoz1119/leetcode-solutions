/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
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
    public boolean isSymmetric(TreeNode root) {
      return helper(root.left, root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        else if(left != null && right != null){
            if(left.val == right.val) return helper(left.right, right.left)&&helper(left.left, right.right);
            else return false;
        }
        else return false;
    }
}

// its iterative equivalence
class Solution {
    public boolean isSymmetric(TreeNode root) {
       Stack<TreeNode> q = new Stack<>();
        q.push(root.left);
        q.push(root.right);
        while (!q.isEmpty()) {
            TreeNode t1 = q.pop();
            TreeNode t2 = q.pop();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.push(t1.left);
            q.push(t2.right);
            q.push(t1.right);
            q.push(t2.left);
        }
        return true;
    }
}
// @lc code=end

