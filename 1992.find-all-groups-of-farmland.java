/*
 * @lc app=leetcode id=1992 lang=java
 *
 * [1992] Find All Groups of Farmland
 */

// @lc code=start
class Solution {
    public int[] dfs(int[][] land, int r, int c){
        if(r+1 < land.length && c+1 < land[0].length && land[r+1][c] == 0 && land[r][c+1]==0 && land[r][c] == 1){
            land[r][c] = 0;
            return new int[]{r, c};
        }
        else if(r+1 == land.length && c+1 < land[0].length && land[r][c+1] == 0 && land[r][c] == 1){
            land[r][c] = 0;
            return new int[]{r, c};
        }else if(r+1 < land.length && c+1 == land[0].length && land[r+1][c] == 0 && land[r][c] == 1){
            land[r][c] = 0;
            return new int[]{r, c};
        }else if(r+1 == land.length && c+1 == land[0].length && land[r][c] == 1){
            land[r][c] = 0;
            return new int[]{r, c};
        }
        else if(r >= land.length||c >= land[0].length||land[r][c]==0){
            return new int[]{-1,-1};
        }
        land[r][c] = 0;
        int[] a = dfs(land, r, c+1);
        int[] b = dfs(land, r+1, c);
        if(a[0] != -1) return a;
        else return b;
    }
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0; i < land.length; i++){
            for (int j = 0; j < land[0].length; j++){
                if(land[i][j]==1){
                    arr.add(new int[]{i, j});
                    arr.add(dfs(land, i, j));
                }
            }
        }
        int[][] result = new int[arr.size()/2][4];
        int j = 0;
        for(int i = 0; i < arr.size(); i++){
            int[] l = arr.get(i);
            result[j][0] = l[0];
            result[j][1] = l[1];
            int[] r = arr.get(++i);
            result[j][2] = r[0];
            result[j][3] = r[1];
            j++;
        }
        return result;
    }
}

//easier solution
class Solution {
    int h = 0;
    int k = 0;
    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(land[i][j] == 1) {
                    int u = i, v = j;
                    dfs(land, u, v, m, n);
                    ans.add(new int[]{i, j, h, k});
                    h = 0; k = 0;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
    public void dfs(int[][] land, int u, int v, int m, int n) {
        if(u < 0 || v < 0 || u >= m || v >= n || land[u][v] == 0) return;
        land[u][v] = 0;
        h = Math.max(h, u);
        k = Math.max(k, v);

        dfs(land, u+1, v, m, n);
        dfs(land, u, v+1, m, n);
    }
}
// @lc code=end

