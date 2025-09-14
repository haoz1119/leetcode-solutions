// Last updated: 9/14/2025, 12:53:45 PM
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