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
class Node implements Comparable<Node>{
    int id;
    int dist;
    public Node(int id,int dist){
        this.id = id;
        this.dist = dist;
    }
    @Override
    public int compareTo(Node o){
        return Integer.compare(this.dist,o.dist);
    }
}
public class Main{
    public static void main(String[] args) throws IOException{
      //读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fL = br.readLine().split(" ");
        int n = Integer.parseInt(fL[0]);
        int m = Integer.parseInt(fL[1]);
        int s = Integer.parseInt(fL[2]);
        int d = Integer.parseInt(fL[3]);

        int[] rescure = new int[n];
        String[] sL = br.readLine().split(" ");
        for(int i = 0;i < n;i++){
            rescure[i] = Integer.parseInt(sL[i]);
        }
        //存地图
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < m;i++){
            String[] str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int len = Integer.parseInt(str[2]);
            adj.get(a).add(new Edge(b,len));
            adj.get(b).add(new Edge(a,len));
        }

        //创立并初始化重要数组
        final int f = Integer.MAX_VALUE / 2;
        int[] dist = new int[n];
        int[] count = new int[n];
        int[] sumRescure = new int[n];
        int[] pre = new int[n];
        Arrays.fill(dist,f);
        Arrays.fill(pre,-1);

        //PQ；初始化start(s)
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dist[s] = 0;
        count[s] = 1;
        sumRescure[s] = rescure[s];
        queue.offer(new Node(s,0));

        //Dijkstra核心逻辑
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int curr = node.id;
            int currDist = node.dist;
            //提前跳过不需要走的地方（已走过且不是最短的）
            if(currDist > dist[curr]){
                continue;
            }
            List<Edge> edges = adj.get(curr);
            for(Edge edge:edges){
                int next = edge.to;
                int len = edge.len;
                int newDist = dist[curr] + len;
                if(dist[next] > newDist){
                    dist[next] = newDist;
                    count[next] = count[curr];
                    pre[next] = curr;
                    sumRescure[next] = sumRescure[curr] + rescure[next];
                    queue.offer(new Node(next,newDist));
                }else if(dist[next] == newDist){
                    count[next] += count[curr];
                    if(sumRescure[next] < sumRescure[curr] + rescure[next]){
                        sumRescure[next] = sumRescure[curr] + rescure[next];
                        pre[next] = curr;
                    }
                }
            }
        }
        // 输出
        System.out.println(count[d] +" "+ sumRescure[d]);
        List<Integer> result = new ArrayList<>();
        int curr = d;
        while(curr != -1){
            result.add(curr);
            curr = pre[curr];
        }
        // 记得倒置
        Collections.reverse(result);
        for(int i = 0;i < result.size();i++){
            System.out.print(result.get(i));
            if(i == result.size() - 1){
                break;
            }
            System.out.print(" ");
        }
        System.out.println();
    }
}
