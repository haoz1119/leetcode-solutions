/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
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
    ArrayList<String> al = new ArrayList<>(); 
    public int sumNumbers(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        int sum = 0;
        for(String s : al){
            sum += Integer.parseInt(s);
        }
        return sum;
    }
    public void dfs(TreeNode root, StringBuilder s){
        if(root == null) return;
        else if(root!= null && root.left == null && root.right == null) {
            s.append(""+root.val);
            al.add(s.toString());
        }
        else {
            s.append(""+root.val);
            int pl = s.length();
            dfs(root.left, s);
            s.delete(pl, s.length());
            dfs(root.right, s);
        }
    }
}

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
// @lc code=end

