import java.util.Scanner;
public class Main {
    static int R;
    static int C;
    static int answer = 0;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        func(0, 0, 0);
        System.out.println(answer);
    }

    private static void func(int a, int b, int count) {
        if(count == 3) {
            if(a == R - 1 && b == C - 1) {
                answer++;
                return;
            } else {
                return;
            }
        }
        char cur = grid[a][b];

        for(int i = a+1; i < R; i++) {
            for(int j = b+1; j < C; j++) {
                if(grid[i][j] != cur) {
                    func(i, j, count+1);
                }
            }
        }
    }
}