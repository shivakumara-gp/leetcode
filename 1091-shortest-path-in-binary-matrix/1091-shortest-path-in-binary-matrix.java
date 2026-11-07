class Pair{
    int row;
    int col;
    int dist;
    public Pair(int row,int col,int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }
}class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->
        Integer.compare(a.dist,b.dist));
        int m=grid.length;
        int n=grid[0].length;
        int dist[]=new int[m*n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        if(grid[0][0]!=0 || grid[m-1][n-1]!=0){
            return -1;
        }
        pq.offer(new Pair(0,0,1));
        dist[0]=1;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int row=cur.row;
            int col=cur.col;
            int curdist=cur.dist;
            if(dist[row*m+col]<curdist){
                continue;
            }
            if(row==m-1 && col==n-1){
                return curdist;
            }
            int dr[]={-1,0,0,1,-1,-1,1,1};
            int dc[]={0,-1,1,0,-1,1,-1,1};
            for(int i=0;i<8;i++){
                int nr=row+dr[i];
                int nc=col+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==0 &&dist[nr*m+nc]>curdist+1){
                    dist[nr*m+nc]=curdist+1;
                    pq.offer(new Pair(nr,nc,curdist+1));
                }
            }
        }
        return -1;
    }
}