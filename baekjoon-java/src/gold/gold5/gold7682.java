package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gold7682 {
    public static char[][] board;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("end")) {
                break;
            }
            solution(str);
        }
    }

    private static void solution(String str) {
        board = new char[3][3];
        int x = 0;
        int o = 0;
        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = str.charAt(index++);
                if (board[i][j] == 'X') {
                    x++;
                } else if (board[i][j] == 'O') {
                    o++;
                }
            }
        }
        if (x - o == 1) {
            if (x + o == 9 && !bingo('O')) {
                System.out.println("valid");
            } else if (bingo('X') && !bingo('O')) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        } else if (x - o == 0) { //o가 이길때
            if (!bingo('X') && bingo('O')) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
        } else {
            System.out.println("invalid");
        }
    }

    private static boolean bingo(char x) {
        //가로
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == x && board[i][1] == x && board[i][2] == x) {
                return true;
            }
        }

        //세로
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == x && board[1][i] == x && board[2][i] == x) {
                return true;
            }
        }
        //대각선
        if (board[0][0] == x && board[1][1] == x && board[2][2] == x) {
            return true;
        }
        if (board[0][2] == x && board[1][1] == x && board[2][0] == x) {
            return true;
        }
        return false;
    }
}
