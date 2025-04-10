import java.util.Scanner;
public class Main {
    static int[][] arr;
    static int n;
    static int answer = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                arr[i][j] = sc.nextInt();

        // Please write your code here.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 2; j++) { //1개 젤 왼쪽 지점
                func(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void func(int a, int b) {
        int total = arr[a][b] + arr[a][b+1] + arr[a][b+2];

        for(int i = a; i < n; i++) {
            for(int j = b; j < n - 2; j++) { //1개 젤 왼쪽 지점
                if(i == a) {
                    if(j == b || j == b+1 || j == b+2) {
                        continue;
                    }
                }
                if(isValid(i, j) && isValid(i, j+1) && isValid(i, j+2)) {
                    int q = total + arr[i][j] + arr[i][j+1] +arr[i][j+2];
                    answer = Math.max(answer, q);
                }
            }
        }
    }

    private static boolean isValid(int y, int x) {
        return y >= 0 && x >= 0 && y < n && x < n;
    }
}