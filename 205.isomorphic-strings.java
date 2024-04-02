/*
 * @lc app=leetcode id=205 lang=java
 *
 * [205] Isomorphic Strings
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        char[] map1 = new char[127];
        char[] map2 = new char[127];
        boolean res = true;
        for(int i = 0; i < s.length(); i++){
            if(map1[s.charAt(i)]!=0){
                res = res && map1[s.charAt(i)] == t.charAt(i);
            }else{
                map1[s.charAt(i)] = t.charAt(i);
            }
        }
        for(int i = 0; i < t.length(); i++){
            if(map2[t.charAt(i)]!=0){
                res = res && map2[t.charAt(i)] == s.charAt(i);
            }else{
                map2[t.charAt(i)] = s.charAt(i);
            }
        }
        return res;
    }
}

// this maps two to the same one which is the index
class Solution {
    public boolean isIsomorphic(String s, String t) {

        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length()!=t.length())
            return false;


        for(int i=0;i<s.length();i++)
        {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }
}
// @lc code=end

