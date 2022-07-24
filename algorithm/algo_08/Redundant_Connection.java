class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // length : [3, 1000]
        UnionFind uf = new UnionFind(1000 + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{-1,-1};
    }
}

class UnionFind {
    int[] parent;
    int[] rank;

    UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
        rank = new int[size];
    }

    public int find(int x) {
        if (x != parent[x]) {
            x = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int p_x = find(x);
        int p_y = find(y);
        if (p_x == p_y) {
            return false;
        } else if (rank[p_x] > rank[p_y]) {
            parent[p_y] = p_x;
        } else if (rank[p_x] < rank[p_y]) {
            parent[p_x] = p_y;
        } else {
            parent[p_x] = p_y;
            rank[p_y]++;
        }
        return true;
    }
}