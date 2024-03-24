/*
 * @lc app=leetcode id=88 lang=java
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] num = new int[m+n];
        int l = 0;
        int r = 0;
        int i = 0;
        while(i < m+n){
            if(l >= m){
                num[i++]=nums2[r++];
            }
            else if(r >= n){
                num[i++]=nums1[l++];
            }
            else if (nums1[l]<=nums2[r]){
                num[i++]=nums1[l++];
            }else{
                num[i++]=nums2[r++];
            }
        }
        for(int j=0; j <m+n; j++){
            nums1[j]=num[j];
        }
    
    }
}
// @lc code=end

