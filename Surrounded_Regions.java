class Solution {
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        UnionFind uf = new UnionFind(board);
        int rows = board.length;
        int cols = board[0].length;
        int dummyBorder = rows * cols;

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols ; j++) {
                if (board[i][j] == 'O') {
                    int border0 = i * cols + j;
                    if (i == 0 || i == rows - 1 || j == 0|| j == cols - 1) {
                        uf.union(dummyBorder, border0);
                        continue;
                    }
                    for (int[] dir : directions) {
                        int nx = i + dir[0];
                        int ny = j + dir[1];
                        if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && board[nx][ny] == 'O') {
                            int neighbor = nx * cols + ny;
                            uf.union(border0, neighbor);
                        }
                    }


                }
            }
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (board[x][y] == 'O' && uf.find(x * cols + y) != uf.find(dummyBorder)) {
                    board[x][y] = 'X';
                }
            }
        }
    }

    class UnionFind {
        int[] parent;

        public UnionFind(char[][] board) {
            int rows = board.length;
            int cols = board[0].length;
            parent = new int[rows * cols + 1];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == 'O') {
                        int id = i * cols + j;
                        parent[id] = id;
                    }
                }
            }
            parent[rows * cols] = rows * cols;
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            } 
        }
    }
}
