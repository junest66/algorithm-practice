import java.util.*;

class Solution
{
    public int solution(int [][]board)
    {
        for(int i = 1; i < board.length; i++) {
            for(int j = 1; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    int minValue = Math.min(board[i-1][j-1], Math.min(board[i][j-1], board[i-1][j]));
                    if(minValue == 0) {
                        continue;
                    } else {
                        board[i][j] = minValue + 1;
                    }
                }
            }
        }

        int max = Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);

        return max * max;
    }
}
