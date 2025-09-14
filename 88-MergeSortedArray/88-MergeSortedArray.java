// Last updated: 9/14/2025, 12:54:29 PM
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            int i = 0;
            for(int l : nums2){
                nums1[i] = l;
                i++;
            }
        }
        else{
            int j = m - 1; // index at nums1
            int k = n - 1; // index at nums2
            for(int i = m+n-1; i >= 0; i--){
                if(j < 0){
                    nums1[i] = nums2[k];
                    k--;
                }else if(k < 0){
                    nums1[i] = nums1[j];
                    j--;
                }else{
                    if(nums1[j] > nums2[k]){
                        nums1[i] = nums1[j];
                        j--;
                    }else
                    {
                        nums1[i] = nums2[k];
                        k--;
                    }
                }
                
            }
        }    
    
    }
}