/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        ls.addAll(inorderTraversal(root.left));
        ls.add(root.val);
        ls.addAll(inorderTraversal(root.right));
        return ls;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ls = new ArrayList<>();
        if(root == null) return ls;
        TreeNode cur = root;
        while(cur != null || !st.empty()){
            if (cur != null){
                // since it is inorder, we want to explore the left subtree first
                // constantly looking for the leftmost node
               st.push(cur);
               cur = cur.left;
           }else{
            // when there is no more left value, we pop middle/root
               cur = st.pop();
               ls.add(cur.val);
               // then we go to the right subtree
               cur = cur.right;
           }
        }
    }
}
// @lc code=end

