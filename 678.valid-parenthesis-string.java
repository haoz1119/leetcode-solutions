/*
 * @lc app=leetcode id=678 lang=java
 *
 * [678] Valid Parenthesis String
 */

// @lc code=start
class Solution {
    public boolean checkValidString(String s) {
        int balance1 = 0;
        int slack1 = 0;
        int balance2 = 0;
        int slack2 = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') balance1++;
            if(s.charAt(i)==')') balance1--;
            if(s.charAt(i)=='*') slack1++;
            if(balance1 + slack1 < 0) return false;
        }
        for(int i = s.length()-1; i >= 0; i--){
            if(s.charAt(i)=='(') balance2--;
            if(s.charAt(i)==')') balance2++;
            if(s.charAt(i)=='*') slack2++;
            if(balance2 + slack2 < 0) return false;
        }
        if(balance1!=0&&(balance1+slack1)<0&&(balance1-slack1)>0) return false;
        if(balance2!=0&&(balance2+slack2)<0&&(balance2-slack2)>0) return false;
        return true;
    }
}
// @lc code=end

