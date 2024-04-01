/*
 * @lc app=leetcode id=587 lang=java
 *
 * [587] Erect the Fence
 */

// @lc code=start
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        boolean start = false;
        for(int i = s.length()-1; i >= 0 ; i--){
            if(s.charAt(i) == ' ' && !start) continue;
            else if (s.charAt(i) == ' ' && start) break;
            else {
                start = true;
                len++;
            }
        }
        return len;
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        String[] st = s.split("\\s+");
        return st[st.length-1].length();
    }
}
// @lc code=end

