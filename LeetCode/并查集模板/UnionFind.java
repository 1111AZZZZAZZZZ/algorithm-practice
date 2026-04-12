import java.util.Arrays;

class UnionFind{
  private int[] fa;
  private int[] size;
  public int cc;
  public UnionFind(int n) {
    fa = new int[n];
    for (int i = 0; i < n; i++) {
        fa[i] = i;
    }
    size = new int[n];
    Arrays.fill(size,1);
    cc = n;
  }
  public int find(int x){
    if(fa[x] != x){
      fa[x] = find(fa[x]);
    }
    return fa[x];
  }
  public boolean isSame(int x,int y){
    return find(x) == find(y);
  }
  public boolean merge(int from,int to){
    int x = find(from);
    int y = find(to);
    if(x==y){
      return false;
    }
    fa[x] = y;
    size[y] += size[x];
    cc--;
    return true;
  }
  public int getSize(int x){
    return size[find(x)];
  }
}
