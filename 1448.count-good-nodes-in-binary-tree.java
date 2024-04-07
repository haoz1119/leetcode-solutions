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

// quicker recursive solution
class Solution {
    private int numGoodNodes = 0;
    
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }
    
    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }
        
        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }
}


// quicker iterative solution,
// using a stack to simulate the recursive call stack
// we can use two stacks instead of a Pair class
class Pair {
    public TreeNode node;
    public int maxSoFar;
    
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, Integer.MIN_VALUE));
        
        while (stack.size() > 0) {
            Pair curr = stack.pop();
            if (curr.maxSoFar <= curr.node.val) {
                numGoodNodes++;
            }
            
            if (curr.node.left != null) {
                stack.push(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
            
            if (curr.node.right != null) {
                stack.push(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
            }
        }

        return numGoodNodes;
    }
}

// BFS solution
class Pair {
    public TreeNode node;
    public int maxSoFar;
    
    public Pair(TreeNode node, int maxSoFar) {
        this.node = node;
        this.maxSoFar = maxSoFar;
    }
}

class Solution {
    public int goodNodes(TreeNode root) {
        int numGoodNodes = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, Integer.MIN_VALUE));
        
        while (queue.size() > 0) {
            Pair curr = queue.poll();
            if (curr.maxSoFar <= curr.node.val) {
                numGoodNodes++;
            }
            
            if (curr.node.right != null) {
                queue.offer(new Pair(curr.node.right, Math.max(curr.node.val, curr.maxSoFar)));
            }

            if (curr.node.left != null) {
                queue.offer(new Pair(curr.node.left, Math.max(curr.node.val, curr.maxSoFar)));
            }
        }

        return numGoodNodes;
    }
}


// @lc code=end

