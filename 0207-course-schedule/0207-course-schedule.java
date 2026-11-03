class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        int x=prerequisites.length;
        
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=0;i<x;i++){
           
                adj[prerequisites[i][1]].add(prerequisites[i][0]);
            
        }
        int[]  vis=new int[n];
        int[] pathvis=new int[n];
        for(int i=0;i<n;i++){
            if(dfs(i,vis,pathvis,adj)==true){
                return false;
            }
        }
        return true;
    }
    public boolean dfs(int node,int[]  vis,int[] pathvis,List<Integer>[] adj){
        vis[node]=1;
        pathvis[node]=1;
        for(int adjs:adj[node]){
            if(vis[adjs]==0){
                if(dfs(adjs,vis,pathvis,adj)==true){
                    return true;
                }
            }else if(pathvis[adjs]==1){
                return true;
            }
        }
        pathvis[node]=0;
        
        return false;
    }
}