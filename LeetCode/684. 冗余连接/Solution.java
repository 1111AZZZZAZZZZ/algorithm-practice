class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Union union = new Union(edges.length);
        for(int i = 0;i < edges.length;i++){
            int[] edge = edges[i];
            if(!union.merge(edge[0],edge[1])){
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
    class Union{
        private int[] fa;
        private int[] size;
        private int cc;
        public Union(int n){
            fa = new int[n+1];
            for(int i = 1;i <= n;i++){
                fa[i] = i;
            }
            size = new int[n+1];
            Arrays.fill(size,1);
            cc = n;
        }
        public int find(int x){
            if(fa[x] != x){
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }
        public boolean isSame(int a,int b){
            return fa[a]==fa[b];
        }
        public boolean merge(int from,int to){
            int x = find(from);
            int y = find(to);
            if(x == y){
                return false;
            }
            fa[x] = y;
            size[y] += size[x];
            cc--;
            return true;
        }
        public int getSize(int a){
            return size[a];
        }
    }
}
