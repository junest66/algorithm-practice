import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int answer = 0;

        for(int i = 0; i <= n-k; i++) {
            // System.out.println("i : " + i);
            int sum = 0;
            for(int j = i; j < i + k; j++) {
                // System.out.println("j : " + j);
                sum += arr[j];
            }
            answer = Math.max(answer, sum);
        }

        System.out.println(answer);
    }
}