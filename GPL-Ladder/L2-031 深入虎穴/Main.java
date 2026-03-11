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

public class Main{
    static class FastScanner {
        private final InputStream in = new BufferedInputStream(System.in);
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= 32); // 跳过空白

            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            int val = 0;
            while (c > 32) {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
    public static void main(String[] args) throws IOException{
        //读取数据
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        //存地图
        List<List<Edge>> adj = new ArrayList<>();
        for(int i = 0;i <= n;i++){
            adj.add(new ArrayList<>());
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1;i <= n;i++){
            int k = fs.nextInt();
            for(int j = 0;j < k;j++){
                int d = fs.nextInt();
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