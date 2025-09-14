// Last updated: 9/14/2025, 12:54:36 PM
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<>();
        else{
            HashMap<String, List<String>> hm = new HashMap<>();
            for(String s : strs){
                char[] c = s.toCharArray();
                Arrays.sort(c);
                String ss = new String(c);
                if(!hm.containsKey(ss)) hm.put(ss, new ArrayList<String>());
                hm.get(ss).add(s);
            }
            return new ArrayList(hm.values());
        }
    }
}