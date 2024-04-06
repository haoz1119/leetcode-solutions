/*
 * @lc app=leetcode id=1249 lang=java
 *
 * [1249] Minimum Remove to Make Valid Parentheses
 */

// @lc code=start
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> st = new Stack<Character>();
        Stack<Integer> sti = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)==')'){
                if(st.empty()) continue;
                else{
                    st.pop();
                    sb.append(")");
                    sti.pop();
                }
            }
            else if(s.charAt(i)=='('){
                st.push(')');
                sb.append("(");
                sti.push(sb.length()-1);
            }
            else {
                sb.append(s.charAt(i));
            }
        }
        if(!st.empty()){
            while(!sti.empty()){
                sb.deleteCharAt(sti.pop());
            }
        }
        return sb.toString();
    }
}
// @lc code=end

