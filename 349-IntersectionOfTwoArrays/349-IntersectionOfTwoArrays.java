// Last updated: 9/14/2025, 12:53:41 PM
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i]) && !ar.contains(nums2[i])) 
                ar.add(nums2[i]);
        }
        int[] intArray = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            intArray[i] = ar.get(i); 
        }
        return intArray;
    }
}