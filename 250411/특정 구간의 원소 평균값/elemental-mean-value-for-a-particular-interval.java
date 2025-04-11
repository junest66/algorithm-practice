import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        // Please write your code here.
        int total = 0;

        for(int i = 0; i < n; i++) { //시작
            for(int j = i; j < n; j++) { //끝
                double average = 0;
                for(int k = i; k <= j; k++) {
                    average += arr[k];
                }
                average /= (j-i + 1);
                for(int k = i; k <= j; k++) {
                    if(average == (double)arr[k]) {
                        // System.out.println("i : " + i +" j : " + j);
                        // System.out.println(average);
                        total++;
                        break;
                    }
                }
            }
        }
        System.out.println(total);
    }
}