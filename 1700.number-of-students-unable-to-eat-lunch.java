/*
 * @lc app=leetcode id=1700 lang=java
 *
 * [1700] Number of Students Unable to Eat Lunch
 */

// @lc code=start
class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        ArrayDeque<Integer> stu = new ArrayDeque<>();
        for(int i : students){
            stu.add(i);
        }
        // boolean sandwichtaken = false;
        int ind = 0;
        int top = 0;
        while(ind != stu.size()){
            int s = stu.poll();
            if(s==sandwiches[top]){
                top++;
                // sandwichtaken = true;
                ind=0;
            }else{
                stu.add(s);
                ind++;
            }
        }
        return stu.size();
    }
}
// @lc code=end

