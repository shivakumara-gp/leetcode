class Solution {
    public void dfs(int[][] grid,int[][] vis,int row,int col){
        int m=grid.length;
        int n=grid[0].length;
        vis[row][col]=1;
        int dr[]={0,-1,0,1};
        int dc[]={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if((nr>=0 && nc>=0 && nr<m && nc<n) && vis[nr][nc]==0 && grid[nr][nc]==1){
                dfs(grid,vis,nr,nc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && grid[0][i]==1){
                dfs(grid,vis,0,i);
            }
            if(vis[m-1][i]==0 && grid[m-1][i]==1){
                dfs(grid,vis,m-1,i);
            }
        }

         for(int j=0;j<m;j++){
            if(vis[j][0]==0 && grid[j][0]==1){
                dfs(grid,vis,j,0);
            }
            if(vis[j][n-1]==0 && grid[j][n-1]==1){
                dfs(grid,vis,j,n-1);
            }
        }
        int cnt=0;
        for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                if(vis[k][l]==0 && grid[k][l]==1){
                    cnt++;
                }
            }
        }
        return cnt;

    }
}