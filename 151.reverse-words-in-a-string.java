/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] st = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < st.length - 1; i++){
            sb.append(st[st.length - i - 1]);
            sb.append(" ");
        }
        sb.append(st[0]);
        return sb.toString().trim();
    }
}
// @lc code=end

