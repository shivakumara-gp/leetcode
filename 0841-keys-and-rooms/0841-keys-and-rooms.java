class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[rooms.size()];
        for(int j=0;j<vis.length;j++){
            vis[j]=false;
        }
        q.offer(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int node=q.poll();
            
            
            for(int x:rooms.get(node)){
                if(vis[x]==false){
                    vis[x]=true;
                    q.offer(x);
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}