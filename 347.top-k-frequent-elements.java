/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap <Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        ArrayList <Integer> [] list = new ArrayList [nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(list[freq] == null){
                list[freq] = new ArrayList<Integer>();
            }
            list[freq].add(key);
        }

        int [] res = new int[k];

        for(int i = list.length-1; k > 0; i--){//O(n)
            if(list[i] == null) continue;
            for(int key : list[i]){
                res[--k] = key;
            }
        }

        return res;
  }  
}

// an solution using priority queue
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        Queue<Integer> pq = new PriorityQueue<>((n1, n2)->count.get(n2)-count.get(n1));
        for(Integer key : count.keySet()){
            pq.add(key);
        }
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }
}
// @lc code=end

