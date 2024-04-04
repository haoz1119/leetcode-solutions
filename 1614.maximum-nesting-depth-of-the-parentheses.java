/*
 * @lc app=leetcode id=1614 lang=java
 *
 * [1614] Maximum Nesting Depth of the Parentheses
 */

// @lc code=start
class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<Character>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') st.push(')');
            if(s.charAt(i)==')') st.pop();
            max = Math.max(max, st.size());
        }
        return max;
    }
}
// @lc code=end

