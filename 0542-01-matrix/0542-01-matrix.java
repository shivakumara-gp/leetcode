class Pair{
    int row;
    int col;
    public Pair(int row,int col){
        this.row=row;
        this.col=col;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int[][] ans=new int[m][n];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                    q.offer(new Pair(i,j));
                }else{
                    ans[i][j]=-1;
                }

            }
        }
        int[] dr={0,-1,0,1};
        int[] dc={-1,0,1,0};
        while(!q.isEmpty()){
            Pair node=q.poll();
            for(int k=0;k<4;k++){
                int nr=node.row+dr[k];
                int nc=node.col+dc[k];
                if((nr>=0 && nc>=0 && nr<m &&nc<n) && ans[nr][nc]==-1 ){
                    q.offer(new Pair(nr,nc));
                    ans[nr][nc]=ans[node.row][node.col]+1;
                }
                
            }
        }
        return ans;
    }
}