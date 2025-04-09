import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int total = 0;
        for(int i = 1; i < n; i++) {
            d[i] = Math.abs(x[i] - x[i-1]) + Math.abs(y[i] - y[i-1]);
            total += d[i];
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i < n - 1; i++) {
            int a = total - (d[i] + d[i+1]) + Math.abs(x[i + 1] - x[i-1]) + Math.abs(y[i + 1] - y[i-1]);
            answer = Math.min(answer, a);
        }
        System.out.println(answer);
        // Please write your code here.
    }
}