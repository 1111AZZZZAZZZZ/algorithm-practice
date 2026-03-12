import java.io.*;
import java.util.*;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }
}

public class Main {
  // 根据前序、中序遍历构建二叉树
  private static TreeNode buildTree(int[] preOrder, int[] inOrder, int preStart, int preEnd, int inStart, int inEnd,
      Map<Integer, Integer> indexMap) {
    // 递归结束
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }
    // 根节点
    int rootVal = preOrder[preStart];
    int rootIndex = indexMap.get(rootVal);
    TreeNode root = new TreeNode(rootVal);
    // 左节点个数
    int leftSize = rootIndex - inStart;
    // 递归
    root.left = buildTree(preOrder, inOrder, preStart + 1, preStart + leftSize, inStart, rootIndex - 1, indexMap);
    root.right = buildTree(preOrder, inOrder, preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd, indexMap);

    return root;
  }

  // 镜面反转
  private static TreeNode mirroTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode temp = root.left;
    root.left = root.right;
    root.right = temp;
    mirroTree(root.left);
    mirroTree(root.right);
    return root;
  }

  // 层序遍历二叉树：BFS
  private static List<Integer> levelOrderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.offer(root);

    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      result.add(node.val);
      //层序遍历：先左后右
      if (node.left != null) {
        q.offer(node.left);
      }
      if (node.right != null) {
        q.offer(node.right);
      }
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    // 中序读取
    String[] SL = br.readLine().split(" ");
    int[] inOrder = new int[n];
    for (int i = 0; i < n; i++) {
      inOrder[i] = Integer.parseInt(SL[i]);
    }
    // 前序读取
    String[] TL = br.readLine().split(" ");
    int[] preOrder = new int[n];
    for (int i = 0; i < n; i++) {
      preOrder[i] = Integer.parseInt(TL[i]);
    }
    HashMap<Integer, Integer> indexMap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      indexMap.put(inOrder[i], i);
    }
    TreeNode tree = buildTree(preOrder, inOrder, 0, n - 1, 0, n - 1, indexMap);
    TreeNode treeMirro = mirroTree(tree);
    List<Integer> result = levelOrderTraversal(treeMirro);
    for (int i = 0; i < n; i++) {
      System.out.print(result.get(i));
      if (i == n - 1) {
        break;
      }
      System.out.print(" ");
    }
    System.out.println();
  }
}