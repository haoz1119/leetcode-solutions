// Last updated: 9/14/2025, 12:54:13 PM
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
    int total = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }
    public void dfs(TreeNode root, int sum){
        if(root == null) {
            return;
        }
        if(root != null && root.left == null && root.right == null){
            total += (sum*10 + root.val);
        }
        dfs(root.left, sum*10+root.val);
        dfs(root.right, sum*10+root.val);
    }
}