// Last updated: 9/14/2025, 12:54:19 PM
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