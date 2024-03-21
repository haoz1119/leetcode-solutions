class solution_704 {
  public int search(int[] nums, int target) {
      int n = nums.length;
      int l = 0;
      int r = n - 1;
      int mid;
      // closed interval, thus here we use <= since there can be only one integer in the array
      while(l <= r){
          mid = (l+r)/2;
          if(nums[mid] == target) return mid;
          if(nums[mid] > target) r = mid - 1;
          if(nums[mid] < target) l = mid + 1;
      }
      return -1;
  }
}