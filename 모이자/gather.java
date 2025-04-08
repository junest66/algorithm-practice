import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        // Please write your code here.
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int total = 0;
            for(int j = 0; j < n; j++) {
                total +=  a[j] * Math.abs(j - i);
            }
            answer = Math.min(answer, total);
        }
        System.out.println(answer);
    }
}