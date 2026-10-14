class Pair{
    int row;
    int col;
   
    public Pair(int row,int col){
        
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        Queue<Pair> q=new LinkedList<>();
        int m=image.length;
        int n=image[0].length;
        int[][] vis=new int[m][n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                vis[i][j]=image[i][j];
            }
        }
        int stcolor=image[sr][sc];
        q.offer(new Pair(sr,sc));
        vis[sr][sc]=color;
        int[] drow={-1,1,0,0};
        int[] dcol={0,0,1,-1};
        while(!q.isEmpty()){
            Pair cur=q.remove();
           
            
            for(int i=0;i<4;i++){
                int nrow=cur.row+drow[i];
                int ncol=cur.col+dcol[i];
                if((nrow>=0 && nrow<m && ncol>=0 && ncol<n) &&vis[nrow][ncol]==stcolor && image[nrow][ncol]==stcolor ){
                    q.offer(new Pair(nrow,ncol));
                    vis[nrow][ncol]=color;
                    
                }
            }
        }
       return vis;
    }
}