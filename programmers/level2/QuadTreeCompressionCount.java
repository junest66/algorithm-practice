class Solution {
    static int[][] board;
    static int zero;
    static int one;

    public int[] solution(int[][] arr) {
        board = arr;

        func(0, 0, arr[0].length);

        return new int[]{zero, one};
    }

    private void func(int i, int j, int size) {
        if(size == 1 || isUniform(i, j, size)) {
            if(board[i][j] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }

        int nextSize = size / 2;
        func(i, j, nextSize);
        func(i, j+nextSize, nextSize);
        func(i+nextSize, j, nextSize);
        func(i+nextSize, j+nextSize, nextSize);
    }

    private boolean isUniform(int y, int x, int size) {
        int base = board[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (board[i][j] != base) {
                    return false;
                }
            }
        }
        return true;
    }
}
