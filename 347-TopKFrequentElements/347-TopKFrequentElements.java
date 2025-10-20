// Last updated: 10/20/2025, 2:55:38 PM
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Queue<Integer> pq = new PriorityQueue<>((a, b)->map.get(a)-map.get(b));
        for(int i : map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--){
            res[i] = pq.poll();
        }
        return res;
    }
}