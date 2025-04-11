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
            board[positions[i]] = candies[i];
        }
        // Please write your code here.
        int answer = 0;

        for(int i = k; i + k < 101; i++) {
            int sum = 0;
            for(int j = i-k; j <= i +k; j++) {
                sum += board[j];
            }
            answer = Math.max(answer, sum);
        }
        
        System.out.println(answer);
    }
}