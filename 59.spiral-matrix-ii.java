/*
 * @lc app=leetcode id=59 lang=java
 *
 * [59] Spiral Matrix II
 */

// @lc code=start
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        // l for left, r for right, t for top, b for bottom
        int l, r, t, b;
        l = t = 0;
        r = b = n - 1;
        int val = 1;
        int i, j;
        i = j = 0;
        while (val < n*n) {
            // fill every val in top row
            for (j = l; j <= r; j++) {
                matrix[i][j] = val++;
            }
            // as we incremented j 1 more time
            j--;
            t++;
            // fill every val in right col
            for (i = t; i <= b; i++) {
                matrix[i][j] = val++;
            }
            i--;
            r--;
            // fill every val in bottom row(reverse order)
            for (j = r; j >= l; j--) {
                matrix[i][j]= val++;
            }
            j++;
            b--;
            // fill every val in left col(reverse order)
            for(i=b; i >= t; i--){
                matrix[i][j]=val++;
            }
            i++;
            l++;
        }
        return matrix;
    }
}
// @lc code=end
