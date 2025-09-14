// Last updated: 9/14/2025, 12:53:09 PM
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


