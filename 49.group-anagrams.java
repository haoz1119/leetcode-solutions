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

// a better solution
// O(nklogk)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new LinkedList<List<String>>();
        LinkedList<List<String>> lls = new LinkedList<>();
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for(String st : strs){ // O(n)
            char[] ch = st.toCharArray();
            Arrays.sort(ch); // O(klogk)
            String ss = new String(ch);
            if(hm.containsKey(ss)){
                hm.get(ss).add(st);
            }
            else{
                LinkedList<String> ls = new LinkedList<>();
                lls.add(ls);
                ls.add(st);
                hm.put(ss, ls);
            }
        }
        return lls;
    }
}

// shortest solution
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Raw Types: When you create an ArrayList without specifying a generic type, you are using a raw type.
    // Using raw types bypasses the type safety provided by generics. This means you can add any type of object to the list, and the compiler won't check if the types are correct.
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
// @lc code=end

