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
// better solution, compare and copy from the end of two arrays, as we are not makeing
// another array
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int l = m - 1; // pointer for first array
        int r = n - 1; // pointer for the second array
        for(int i = 0; i < m+n; i++){
            if(l < 0) {
                nums1[m+n-1-i]=nums2[r--];
            }else if(r<0) return;
            else if(nums1[l] > nums2[r]) nums1[m+n-1-i]= nums1[l--];
            else{
                nums1[m+n-1-i]=nums2[r--];
            }
        }
    }
}
// @lc code=end

