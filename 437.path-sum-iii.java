/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
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
    // number of paths that starting at root, we dfs to find paths that starting at root and
    // sums up to targetSum, we will stop until to the leaf node, along the search as soon as the
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
    // we recursively call helper to get the number of valid paths starting at a certain node
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        if(root == null) return 0;
        count += helper(root, targetSum, 0);
        count += pathSum(root.left, targetSum)+pathSum(root.right, targetSum);
        return count;
    }
}

class Solution {
    int count = 0;
    int k;
    HashMap<Long, Integer> h = new HashMap();
    
    public void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;
        
        // The current prefix sum
        currSum += node.val;

        // Here is the sum we're looking for
        if (currSum == k)
            count++;
        
        // The number of times the curr_sum − k has occurred already, 
        // determines the number of times a path with sum k 
        // has occurred up to the current node
        count += h.getOrDefault(currSum - k, 0);
        
        //Add the current sum into the hashmap
        // to use it during the child node's processing
        h.put(currSum, h.getOrDefault(currSum, 0) + 1);

        // Process the left subtree
        preorder(node.left, currSum);

        // Process the right subtree
        preorder(node.right, currSum);

        // Remove the current sum from the hashmap
        // in order not to use it during 
        // the parallel subtree processing
        h.put(currSum, h.get(currSum) - 1);
    }    
            
    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }
}
// @lc code=end

