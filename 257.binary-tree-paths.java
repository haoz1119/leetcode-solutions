/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
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
    public List<String> binaryTreePaths(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        Stack<String> str = new Stack<>();
        ArrayList<String> sl = new ArrayList<>();
        if(root == null) return sl;
        st.push(root);
        str.push(""+root.val);
        while(!st.empty()){
            TreeNode node = st.pop();
            if(node.left == null && node.right == null){
                sl.add(str.pop());
            } else {
                String s = str.pop();
                if(node.right != null) {
                    st.push(node.right);
                    str.push(s+"->"+node.right.val);
                }
                if(node.left != null) {
                    st.push(node.left);
                    str.push(s+"->"+node.left.val);
                }
            }
        } 
        return sl;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> sl = new ArrayList<>();
        if(root == null) return sl;
        String s = ""+root.val;
        if(root.left == null && root.right == null) {
            sl.add(s);
            return sl;
        }
        if(root.left!=null){
            List<String> arr = binaryTreePaths(root.left);
            for(String str : arr){
                sl.add(s+"->"+str);
            }
        }
        if(root.right!=null){
            List<String> arr = binaryTreePaths(root.right);
            for(String str : arr){
                sl.add(s+"->"+str);
            }
        }
        return sl;
    }
}
// @lc code=end

