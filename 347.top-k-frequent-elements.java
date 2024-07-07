/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        // array of arraylist of integers
        ArrayList<Integer>[] al = new ArrayList[nums.length+1]; // because the biggest count will be nums.length
        for(int key : count.keySet()){
            int freq = count.get(key);
            if(al[freq] == null) al[freq] = new ArrayList<Integer>();
            al[freq].add(key);
        }
        int[] result = new int[k];
        for(int i = nums.length; k>0; i--){
            if(al[i]!=null){
                for(int n : al[i]){
                    if(k > 0) // guard against the case when the list has more than k elements
                        result[--k] = n;
                }
            }
        }
        return result;
    }
}

// an solution using priority queue
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        // comparator for the priority queue, work as a max heap, n1 is in front of n2 if count.get(n2) - count.get(n1) < 0
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

