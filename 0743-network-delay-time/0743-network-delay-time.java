class Pair{
    int dist;
    int node;
    public Pair(int dist,int node){
        this.dist=dist;
        this.node=node;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int j=0;j<times.length;j++){
            int u=times[j][0];
            int v=times[j][1];
            int weight=times[j][2];
           adj.get(u).add(new Pair(weight, v));
        }
         PriorityQueue<Pair> pq=new PriorityQueue<>(
            (a,b)->Integer.compare(a.dist,b.dist));;
        int dist[]=new int[adj.size()+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.add(new Pair(0,k));
        
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            int curdist=cur.dist;
            int node=cur.node;
            for(Pair it:adj.get(node)){
                int x=it.node;
                int weight=it.dist;
                if(dist[x]>weight+curdist){
                    dist[x]=weight+curdist;
                    pq.add(new Pair(weight+curdist,x));
                }
            }
        }
        int maxi=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            maxi=Math.max(maxi,dist[i]);
        }
        return maxi==Integer.MAX_VALUE?-1:maxi;
    }
}