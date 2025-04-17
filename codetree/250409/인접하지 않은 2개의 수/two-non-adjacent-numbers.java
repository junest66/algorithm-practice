import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        
        int answer = 0;

        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 2; j < arr.length; j++) {
                answer = Math.max(arr[i] + arr[j], answer);
            }
        }

        System.out.println(answer);
        // Please write your code here.
    }
}