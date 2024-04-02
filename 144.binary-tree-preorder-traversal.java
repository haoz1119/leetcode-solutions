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

// iterative solution using stack. push the right on first before
// push the left, so that the left will be popped first
// and we constantly popping  the left node first, delaying the right node 
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ls = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return ls;
        else st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            ls.add(node.val);
            if(node.right != null) st.push(node.right);
            if(node.left != null) st.push(node.left);
        }
        return ls;
    }
}
// @lc code=end

