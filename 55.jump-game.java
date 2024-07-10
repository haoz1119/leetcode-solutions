/*
 * @lc app=leetcode id=55 lang=java
 *
 * [55] Jump Game
 */

// @lc code=start
// a working solution but not efficient
class Solution {
    private boolean[] canIn;
    private boolean[] updated;
    public boolean canJump(int[] nums) {
        canIn = new boolean[nums.length];
        updated = new boolean[nums.length];
        return canJump(nums, 0);
    }
    private boolean canJump(int[] nums, int index){
        if(updated[index]) return canIn[index];
        if(index == nums.length - 1){
            canIn[index] = true;
            updated[index] = true;
            return true;
        }
        else if(nums[index] == 0){
            canIn[index] = false;
            updated[index] = true;
            return false;
        }
        else{
            boolean result = false;
            int first = index;
            int jumpTo = index;
            int step = Math.min(index + nums[index], nums.length - 1) - index;
            while(step > 0){
                jumpTo = index+step;
                if(updated[jumpTo]) result = result || canIn[index];
                else result = result || canJump(nums, jumpTo);
                step--;
            }
            canIn[index] = result;
            updated[index] = true;
            return result;
        }
    }
}

// similar solution
class Solution {
    private boolean[] canIn;
    private boolean[] updated;
    public boolean canJump(int[] nums) {
        canIn = new boolean[nums.length];
        updated = new boolean[nums.length];
        return canJump(nums, 0);
    }
    private boolean canJump(int[] nums, int index){
        if(updated[index]) return canIn[index];
        if(index == nums.length - 1){
            canIn[index] = true;
            updated[index] = true;
            return true;
        }
        else if(nums[index] == 0){
            canIn[index] = false;
            updated[index] = true;
            return false;
        }
        else{
            boolean result = false;
            int first = index;
            int jumpTo = index;
            int step = Math.min(index + nums[index], nums.length - 1) - index;
            while(step > 0){
                jumpTo = index + step;
                if(canJump(nums, jumpTo)) {
                    updated[index] = true;
                    canIn[index] = true;
                    return true; 
                }
                step--;
            }
            canIn[index] = false;
            updated[index] = true;
            return canIn[index];
        }
    }
}

// greedy solution
public class Solution {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}
// @lc code=end

