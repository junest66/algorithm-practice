import java.util.Scanner;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int answer = 10001;

        int sum = Arrays.stream(arr).sum();

        for(int i = 0; i < n - 1; i++) {
            for(int j = i+1; j < n; j++) {
                int value = sum - arr[i] - arr[j];
                answer = Math.min(Math.abs(s - value), answer);
            }
        }
        System.out.println(answer);
        // Please write your code here.
    }
}