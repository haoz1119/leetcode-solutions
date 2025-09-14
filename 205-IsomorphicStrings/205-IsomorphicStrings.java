// Last updated: 9/14/2025, 12:53:53 PM
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