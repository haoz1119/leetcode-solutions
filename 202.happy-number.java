/*
 * @lc app=leetcode id=202 lang=java
 *
 * [202] Happy Number
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            if(!set.contains(n)) set.add(n);
            n = sumOfSquare(n);  
        }
        return n == 1;
    }

    private static int sumOfSquare(int n){
        int sum = 0;
        while(n > 0){
            sum += (n % 10)*(n % 10);
            n /= 10;
        }
        return sum;
    }
}
// @lc code=end

