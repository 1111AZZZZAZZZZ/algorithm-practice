import java.io.*;
import java.util.*;
class Edge{
    int to;
    int len;
    public Edge(int to,int len){
        this.to = to;
        this.len = len;
    }
}
public class MySolution{
    public static void main(String[] args) throws IOException{
        //读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //存地图
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st;
        for(int i = 1;i <= n;i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for(int j = 0;j < k;j++){
                int d = Integer.parseInt(st.nextToken());
                adj.get(i).add(new Edge(d,1));
                if(!set.contains(d)){
                    set.add(d);
                }
            }
        }
        //找入口
        int start = 0;
        for(int i = 1;i <= n;i++){
            if(!set.contains(i)){
                start = i;
                break;
            }
        }
        // 创立重要数据
        // int[] dist = new int[n];
        int result = start;
        // Arrays.fill(dist,-1);
        //Queue
        Queue<Integer> queue = new LinkedList<>();
        // dist[start] = 0;
        queue.offer(start);
        //BFS
        while(!queue.isEmpty()){
            int curr  = queue.poll();
            List<Edge> edges = adj.get(curr);
            for(Edge edge:edges){
                int next = edge.to;
                int len = edge.len;
                // dist[next] = dist[curr] + len;
                result = next;
                queue.add(next);
            }
            
        }
        System.out.println(result);
    }

}