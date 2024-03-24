/*
 * @lc app=leetcode id=459 lang=java
 *
 * [459] Repeated Substring Pattern
 */

// @lc code=start
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int size = s.length();
        boolean b = false;
        for(int i = 0; i < size/2; i++){
            boolean bb = true;
            String sub = s.substring(0, i+1);
            int j = 1;
            if (size % (i+1)!= 0){
                bb = false;
                continue;
            }
            while((j+1)*(i+1) <= size){
                String sub2 = s.substring(j*(i+1), (j+1)*(i+1));
                if(!sub.equals(sub2)) {
                    bb = false;
                    break;
                }
                j++;
            }
            b = b || bb;
            
        }
        return b;
    }
}
// @lc code=end

