class Pair{
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time){
        this.time=time;
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];
        int freshcnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                    vis[i][j]=2;
                }else{
                    vis[i][j]=0;
                }
            if(grid[i][j]==1)freshcnt++;
            }
        }
        int tm=0;
        int cnt=0;
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,1,-1};
        while(!q.isEmpty()){
            Pair cur=q.remove();
           
            int ntime=cur.time;
            tm=Math.max(ntime,tm);
            for(int i=0;i<4;i++){
                int nrow=cur.row+drow[i];
                int ncol=cur.col+dcol[i];
                if((nrow>=0 && nrow<m && ncol>=0 && ncol<n) &&vis[nrow][ncol]==0 && grid[nrow][ncol]==1 ){
                    q.offer(new Pair(nrow,ncol,ntime+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }
        }
        if(cnt!=freshcnt) return -1;
        return tm;
    }
}