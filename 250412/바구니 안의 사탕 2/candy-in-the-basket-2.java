import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        int[] board = new int[101];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
            board[positions[i]] += candies[i];
        }
        // Please write your code here.
        int answer = 0;

        for(int i = 0; i < 101; i++) {
            int sum = 0;
            int start = i - k < 0 ? 0 : i-k;
            int end = i + k >= 101 ? 100 : i+k;
            for(int j = start; j <= end; j++) {
                sum += board[j];
            }
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
}