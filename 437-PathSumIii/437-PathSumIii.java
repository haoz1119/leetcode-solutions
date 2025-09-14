// Last updated: 9/14/2025, 12:53:37 PM
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
    // helper returns the number of valid paths that starts at root, 
    // we dfs to find paths that starting at root and sums up to targetSum.
    // along the search as soon as the
    // sum of the path sums up to targetSum, we increment the count
    public int helper(TreeNode root, int targetSum, long curSum){
        int count = 0;
        if(root == null) return 0;
        curSum += root.val;
        if(curSum == targetSum) count++;
        count += helper(root.left, targetSum, curSum);
        count += helper(root.right, targetSum, curSum);
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if(root == null) return 0;
        count += helper(root, targetSum, 0);
        count += pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
        return count;
    }
}