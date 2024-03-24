/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS != lenT) return false;
        // the most import point here is that there is only 26 letters
        int[] f = new int[26];
        for(int i = 0; i < lenS; i++){
            f[s.charAt(i)-'a']++;
        }
        for(int i = 0; i < lenT; i++){
            f[t.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(f[i] > 0) return false;
        }
        return true;
        
    }
}
// @lc code=end

