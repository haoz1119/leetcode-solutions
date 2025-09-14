// Last updated: 9/14/2025, 12:54:30 PM
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l, r, t, b;
        l = t = 0;
        r = b = n - 1;
        int val = 1;
        int i, j;
        i = j = 0;
        while (val <= n*n) {
            // fill every val in top row
            for (j = l; j <= r; j++) {
                matrix[i][j] = val++;
            }
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