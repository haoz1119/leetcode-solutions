// Last updated: 9/14/2025, 12:53:55 PM
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int n : nums){
            if (hs.contains(n)) return true;
            else hs.add(n);
        }
        return false;
    }
}