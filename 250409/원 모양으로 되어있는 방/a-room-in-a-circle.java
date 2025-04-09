import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int total = 0;
            int count = 1;
            for(int j = i + 1; j < i + n; j++) {
                total += arr[j%n] * count++;
            }
            answer = Math.min(answer, total);
        }
        System.out.println(answer);
    }
}