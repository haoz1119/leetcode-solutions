// Last updated: 9/14/2025, 12:53:49 PM
class Solution {
    public boolean isAnagram(String s, String t) {
        int arrs[] = new int[26];
        if(s.length() != t.length()) return false;
        else{
            for(int i = 0; i < s.length(); i++){
                arrs[s.charAt(i)-'a']++;
            }
            for(int i = 0; i < t.length(); i++){
                arrs[t.charAt(i)-'a']--;
                if(arrs[t.charAt(i)-'a'] < 0) return false;
            }
            for(int i = 0; i < t.length(); i++){
                if(arrs[t.charAt(i)-'a'] != 0) return false;
            }
            return true;
        }
    }
}