/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
// not very optimized answer
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new LinkedList<List<String>>();
        if(strs.length == 1) {
            LinkedList<String> ls = new LinkedList<String>();
            ls.push(strs[0]);
            LinkedList<List<String>> lls = new LinkedList<>();
            lls.add(ls);
            return lls;
        }
        else{
            LinkedList<List<String>> lls = new LinkedList<>();
            for(String st : strs){
                if(lls.size() > 0){
                    boolean f = true;
                    for(List<String> ls : lls){
                        f = true;
                        String s = ls.get(0);
                        if(s.length() != st.length()){
                            f = false;
                            continue;
                        }
                        int[] arr = new int[26];
                        for(int i = 0; i < s.length(); i++){
                            arr[s.charAt(i)-'a']++;
                        }
                        for(int i = 0; i < s.length(); i++){
                            arr[st.charAt(i)-'a']--;
                            if(arr[st.charAt(i)-'a']<0) {
                                f = false;
                                break;
                            }
                        }
                        if(f){
                            ls.add(st);
                            break;
                        } 
                        else continue;
                    }
                    if(!f){
                        LinkedList<String> ls = new LinkedList<>();
                        ls.add(st);
                        lls.add(ls);
                    }
                }else{
                    LinkedList<String> ls = new LinkedList<>();
                    ls.add(st);
                    lls.add(ls);
                }
            }
            return lls;
        }
    }
}
// @lc code=end

