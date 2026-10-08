class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis=new boolean[isConnected.length];
        int cnt=0;
        for(int i=0;i<isConnected.length;i++){
            if(!vis[i]){
                cnt++;
                Queue<Integer> q=new LinkedList<>();
                vis[i]=true;
                q.offer(i);
                while(!q.isEmpty()){
                    int city=q.poll();
                    for(int j=0;j<isConnected.length;j++){
                        if(isConnected[city][j]==1 && !vis[j]){
                            vis[j]=true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return cnt; 
    }
    
}