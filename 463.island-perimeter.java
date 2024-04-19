/*
 * @lc app=leetcode id=463 lang=java
 *
 * [463] Island Perimeter
 */

// @lc code=start
class Solution {
    public int islandPerimeter(int[][] grid) {
        int peri = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(i == 0){
                    if(j == 0){
                        if(grid[i][j]==1){
                            peri += 2;
                            if(i+1 >= row || grid[i+1][j] == 0) peri++;
                            if(j+1 >= col || grid[i][j+1] == 0) peri++;
                        }
                    } else if(j == col - 1){
                        if(grid[i][j]==1){
                            peri += 2;
                            if(j-1 < 0 || grid[i][j-1] == 0) peri++;
                            if(i+1 >=row || grid[i+1][j] == 0) peri++;
                        }
                    }else{
                        if(grid[i][j] == 1){
                            peri++;
                            if(j-1 < 0 || grid[i][j-1]==0) peri++;
                            if(j+1 >=col || grid[i][j+1]==0) peri++;
                            if(i+1 >= row || grid[i+1][j]==0) peri++;
                        }
                    }
                } else if(i == row - 1){
                    if(j == 0){
                        if(grid[i][j]==1){
                            peri += 2;
                            if(i-1 < 0 || grid[i-1][j] == 0) peri++;
                            if(j+1 >= col || grid[i][j+1] == 0) peri++;
                        }
                    }else if(j == col - 1){
                        if(grid[i][j]==1){
                            peri += 2;
                            if(i-1 < 0 || grid[i-1][j] == 0) peri++;
                            if(j-1 < 0 || grid[i][j-1] == 0) peri++;
                        }
                    }else{
                        if(grid[i][j] == 1){
                            peri++;
                            if(j-1 < 0 || grid[i][j-1]==0) peri++;
                            if(j+1 >= col || grid[i][j+1]==0) peri++;
                            if(i-1 < 0 || grid[i-1][j]==0) peri++;
                        }
                        
                    }
                } else if(j == 0 && (i != 0 || i != row - 1)){
                    if(grid[i][j]==1){
                        peri++;
                        if(i-1 < 0 || grid[i-1][j]==0) peri++;
                        if(i+1 >= row || grid[i+1][j]==0) peri++;
                        if(j+1 >= col || grid[i][j+1]==0) peri++;
                    }
                } else if(j == col - 1 && (i != 0 || i != row - 1)){
                    if(grid[i][j]==1){
                        peri++;
                        if(i-1 <0 || grid[i-1][j]==0) peri++;
                        if(i+1 >=row || grid[i+1][j]==0) peri++;
                        if(j-1 < 0 || grid[i][j-1]==0) peri++;
                    }
                } else{
                    if(grid[i][j]==1){
                        if(j-1 < 0 || grid[i][j-1]==0) peri++;
                        if(j+1 >= col || grid[i][j+1]==0) peri++;
                        if(i+1 >= row || grid[i+1][j]==0) peri++;
                        if(i-1 < 0 || grid[i-1][j]==0) peri++;
                    }
                }
            }
        }
        return peri;
    }
}
// @lc code=end

