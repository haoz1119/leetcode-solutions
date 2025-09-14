// Last updated: 9/14/2025, 12:54:02 PM
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int n = s.length();
        int dist = 0;
        int max = 0;
        for(int left = 0, right = 0; right < n; right++){
            if(!set.containsKey(s.charAt(right))){
                dist++;
            }
            set.put(s.charAt(right), set.getOrDefault(s.charAt(right), 0)+1);
            while(dist > 2){
                set.put(s.charAt(left), set.get(s.charAt(left))-1);
                if(set.get(s.charAt(left)) == 0){
                    set.remove(s.charAt(left));
                    dist--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);

        }
        return max;
    }
}