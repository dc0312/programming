package practice.graphs;

public class CountNumberOfIslands {
    public static void main(String[] args) {
//        int M[][] = new int[][]{{0, 0, 1, 1, 1, 1, 1, 1},
//                {0, 0, 1, 1, 1, 1, 1, 1},
//                {1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 0, 0, 0, 1, 1, 0},
//                {1, 1, 1, 1, 0, 1, 1, 0},
//                {1, 1, 1, 1, 0, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0},
//                {1, 1, 1, 1, 1, 1, 1, 0}};

        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        System.out.println("Count Islands : " + countIslands(M));
    }

    private static int countIslands(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 1 && !visited[i][j]) {
                    drawTreeForComponent(M, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void drawTreeForComponent(int[][] M, int i, int j, boolean[][] visited) {

        if (i < 0 || i >= M.length || j < 0 || j >= M[0].length || M[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        drawTreeForComponent(M, i - 1, j, visited);
        drawTreeForComponent(M, i, j + 1, visited);
        drawTreeForComponent(M, i + 1, j, visited);
        drawTreeForComponent(M, i, j - 1, visited);
    }
}
