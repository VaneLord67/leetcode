package union;

/**
 * @author CJR
 * @create 2023-03-05-21:34
 */
public class UnionFind {
    private static final int MAXN = 100010;
    private int[] fa = new int[MAXN]; // fa[i]表示i的祖先

    public void init() {
        for (int i = 0; i < MAXN; i++) {
            fa[i] = i;
        }
    }

    // 找到i的祖先
    public int find(int i) {
        if (fa[i] == i) {
            return i;
        }
        fa[i] = find(fa[i]); // 路径压缩
        return fa[i];
    }

    // 合并
    public void union(int i, int j) {
        // 找到i和j的祖先，让i的祖先的祖先指向j的祖先
        int x = find(i);
        int y = find(j);
        if (x != y) {
            fa[x] = y;
        }
    }
}
