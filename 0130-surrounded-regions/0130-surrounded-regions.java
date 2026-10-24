class Solution {
    public void dfs(char[][] board,int[][] vis,int row,int col){
        int m=board.length;
        int n=board[0].length;
        vis[row][col]=1;
        int dr[]={0,-1,0,1};
        int dc[]={-1,0,1,0};
        for(int i=0;i<4;i++){
            int nr=row+dr[i];
            int nc=col+dc[i];
            if((nr>=0 && nc>=0 && nr<m && nc<n) && vis[nr][nc]==0 && board[nr][nc]=='O'){
                dfs(board,vis,nr,nc);
            }
        }
    }
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int[][] vis=new int[m][n];
        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(board,vis,0,i);
            }
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(board,vis,m-1,i);
            }
        }

         for(int j=0;j<m;j++){
            if(vis[j][0]==0 && board[j][0]=='O'){
                dfs(board,vis,j,0);
            }
            if(vis[j][n-1]==0 && board[j][n-1]=='O'){
                dfs(board,vis,j,n-1);
            }
        }

        for(int k=0;k<m;k++){
            for(int l=0;l<n;l++){
                if(vis[k][l]==0 && board[k][l]=='O'){
                    board[k][l]='X';
                }
            }
        }
    }
}