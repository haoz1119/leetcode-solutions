/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        int l = s.length();
        if(l%2!=0) return false;
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < l; i++){
            if(s.charAt(i)=='(') {
                st.push('(');
            }
            else if(s.charAt(i)=='{') {
                st.push('{');
            }
            else if(s.charAt(i)=='[') {
                st.push('[');
            }
            else if(s.charAt(i)==']') {
                if(st.empty()||!st.pop().equals('[')) return false;
            }
            else if(s.charAt(i)=='}') {
                if(st.empty()||!st.pop().equals('{')) return false;
            }
            else if(s.charAt(i)==')') {
                if(st.empty()||!st.pop().equals('(')) return false;
            }
            
        }
        if(!st.empty()) return false;
        return true;
    }
}
// @lc code=end

