class Solution {
    public boolean dfs(int[][] graph,int[] vis,int[] pathvis,int[] check,int i){
        vis[i]=1;
        pathvis[i]=1;
        check[i]=0;
        for(int j=0;j<graph[i].length;j++){
            int adj=graph[i][j];
            if(vis[adj]==0){
                if(dfs(graph,vis,pathvis,check,adj)==true){
                    return true;
                }
            }
            else if(pathvis[adj]==1){
                return true;
            }
        }
        pathvis[i]=0;
        check[i]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int vis[]=new int[graph.length];
        int pathvis[]=new int[graph.length];
        int check[]=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            if(vis[i]==0){
                dfs(graph,vis,pathvis,check,i);
            }
        }
        List<Integer> safeNodes=new ArrayList<>();
        for(int i=0;i<check.length;i++){
            if(check[i]==1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
}