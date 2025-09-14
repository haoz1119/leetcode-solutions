// Last updated: 9/14/2025, 12:53:20 PM
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
    String mins = "";
    boolean first = true;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return mins;
    }
    public void dfs(TreeNode root, String curs){
        if(root == null) return;
        if(root != null && root.left == null && root.right == null){
            char c = (char)((int)'a'+ root.val);
            curs = ""+ c + curs;
            boolean smaller = true;
            boolean same = true;
            for(int i = 0; i < Math.min(curs.length(), mins.length()); i++){
                if(curs.charAt(i) > mins.charAt(i)){
                    smaller = false;
                    same = false;
                    break;
                }else if(curs.charAt(i) < mins.charAt(i)){
                    same = false;
                    break;
                }
            }
            if(same && curs.length() > mins.length()) smaller = false;
            if(first || smaller){
                mins = curs;
                first = false;
            }
        }
        else {
            char c = (char)((int)'a'+ root.val);
            dfs(root.left, ""+c+curs);
            dfs(root.right, ""+c+curs);
        }
    }
}