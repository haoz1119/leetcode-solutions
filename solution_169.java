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

