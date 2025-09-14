// Last updated: 9/14/2025, 12:53:11 PM
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