/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        ls.addAll(postorderTraversal(root.left));
        ls.addAll(postorderTraversal(root.right));
        ls.add(root.val);
        return ls;
    }
}

// iterative solution 
// we created a list with mid - right - left order, and reverse it into
// the postorder left right mid
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            ls.add(node.val);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }
        Collections.reverse(ls);
        return ls;
    }
}
// @lc code=end

