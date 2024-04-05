/*
 * @lc app=leetcode id=1544 lang=java
 *
 * [1544] Make The String Great
 */

// @lc code=start
class Solution {
    public String makeGood(String s) {
        if(s.length() < 2) return s;
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(i != s.length() - 1 && s.charAt(i)!=s.charAt(i+1) && Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(i+1))){
                i++;
            }
            else {
                if(!st.empty()){
                    char c = st.peek();
                    if(s.charAt(i)!=c && Character.toLowerCase(s.charAt(i))==Character.toLowerCase(c)){
                        sb.deleteCharAt(sb.length() - 1);
                        st.pop();
                        continue;
                    }
                }
                sb.append(s.charAt(i));
                st.push(s.charAt(i));
             
            }
            
        }
        return sb.toString();
    }
}
// @lc code=end

