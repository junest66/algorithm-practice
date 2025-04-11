import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[10001];
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            if(c == 'G') {
                arr[pos] = 1;
            } else if(c == 'H') {
                arr[pos] = 2;
            }
            maxValue = Math.max(maxValue, pos);
        }

        int answer = 0;

        for(int i = 1; i <= maxValue - k; i++) {
            // System.out.println(i);
            int sum = 0;
            for(int j = i; j < i + k + 1; j++) {
                // System.out.println(j);
                sum += arr[j];
            }
            answer = Math.max(answer, sum);
        }
        // Please write your code here.
        System.out.println(answer);
    }
}