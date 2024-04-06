/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else {
            if(root.left == null && root.right == null){
                return null;
            }else if(root.left != null && root.right == null){
                return root.left;
            }else if(root.right != null && root.left == null){
                return root.right;
            }else {
                TreeNode cur = root.left;
                TreeNode prev = root;
                while(cur.right != null){
                    prev = cur;
                    cur = cur.right;
                }
                TreeNode pred = cur;
                deleteNode(root, pred.val);
                pred.left = root.left;
                pred.right = root.right;
                return pred;
            }
        }
        return root;
    }
}
// @lc code=end

