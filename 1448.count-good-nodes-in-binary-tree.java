/*
 * @lc app=leetcode id=1448 lang=java
 *
 * [1448] Count Good Nodes in Binary Tree
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
    public int dfs(TreeNode root, ArrayList<Integer> arr){
        int count = 0;
        if(root == null) {
            return 0;
        }

        count++;
        // check every node on the path
        for(int i : arr){
            if(i > root.val) {
                count--;
                break;
            }
        }
        arr.add(root.val);
        count += dfs(root.left, arr);
        count += dfs(root.right, arr);
        arr.remove(arr.size()-1);
        return count;
    }
    public int goodNodes(TreeNode root) {
        int count = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return 0;
        arr.add(root.val);
        count = 1 + dfs(root.left, arr) + dfs(root.right, arr);
        return count;
    }
}
// @lc code=end

