class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void bfs(int i, int j, char[][] board, int[][] visited) {
        Point p = new Point(i, j);
        Queue<Point> qq = new LinkedList<>();
        qq.add(p);
        visited[i][j] = 1;  // Mark the starting point as visited
        int m = board.length, n = board[0].length;
        while (!qq.isEmpty()) {
            Point curr = qq.poll();
            i = curr.x;
            j = curr.y;

            // Check all four directions
            if (i + 1 < m && board[i + 1][j] == 'O' && visited[i + 1][j] == 0) {
                visited[i + 1][j] = 1;
                qq.add(new Point(i + 1, j));
            }
            if (j + 1 < n && board[i][j + 1] == 'O' && visited[i][j + 1] == 0) {
                visited[i][j + 1] = 1;
                qq.add(new Point(i, j + 1));
            }
            if (i - 1 >= 0 && board[i - 1][j] == 'O' && visited[i - 1][j] == 0) {
                visited[i - 1][j] = 1;
                qq.add(new Point(i - 1, j));
            }
            if (j - 1 >= 0 && board[i][j - 1] == 'O' && visited[i][j - 1] == 0) {
                visited[i][j - 1] = 1;
                qq.add(new Point(i, j - 1));
            }
        }
    }

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] visited = new int[m][n];
        // 1. Traverse the border of the board and perform BFS on each 'O' found(visit all non-surrounded islands)
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && visited[i][0] == 0) {
                bfs(i, 0, board, visited);
            }
            if (board[i][n - 1] == 'O' && visited[i][n - 1] == 0) {
                bfs(i, n - 1, board, visited);
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && visited[0][j] == 0) {
                bfs(0, j, board, visited);
            }
            if (board[m - 1][j] == 'O' && visited[m - 1][j] == 0) {
                bfs(m - 1, j, board, visited);
            }
        }
        // 2. Flip all unvisited 'O' cells to 'X'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && visited[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}
