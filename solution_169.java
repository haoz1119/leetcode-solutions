import java.util.Hashtable;
class solution_169 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Hashtable<Integer, Integer> times = new Hashtable<>();
        int majority = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
            times.put(nums[i], 0);
        for(int i = 0; i < n; i++){
            times.put(nums[i], times.get(nums[i])+1);
            if (times.get(nums[i]) > n/2)
                majority = nums[i];
        }
        return majority;

    }
    /**
     * Moore's Voting Algorithm
     * pick the first element as the candidate and increment its count by one, if next element is
     * the same as the candidate we increment the count, otherwise we decrement the count. when the 
     * count is 0, we pick the next element as the candidate
     * 
     * correctness discussion:
     * the majority will have a net positive count to itself since it appears more than n/2 times
     */
    public int majorityElement_Better(int[] nums) {
      int count = 0;
      int element = 0;

      for (int num : nums) {
          if (count == 0) {
              element = num;
              count = 1;
          } else if (element == num) {
              count++;
          } else {
              count--;
          }
      }

      return element;
    }
}
