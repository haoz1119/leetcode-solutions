/*
 * @lc app=leetcode id=2073 lang=java
 *
 * [2073] Time Needed to Buy Tickets
 */

// @lc code=start
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0; 
        int i = 0;
        while(tickets[k] > 0){
            if(tickets[i] == 0) {
                i = (i+1)%tickets.length;
                continue;
            }
            tickets[i]--;
            time++;
            i = (i+1)%tickets.length;
        }
        return time;
    }
}


class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < tickets.length; i++){
            q.offer(i);
        }
        int time = 0;
        while(tickets[k] > 0){
            int i = q.poll();
            time++;
            tickets[i]--;
            if(tickets[i]==0) continue;
            else q.offer(i);   
        }
        return time;
    }
}


// @lc code=end

