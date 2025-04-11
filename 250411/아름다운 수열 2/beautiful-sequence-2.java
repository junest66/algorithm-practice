import java.util.Scanner;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        
        Set<Integer> setB = Arrays.stream(B).boxed().collect(Collectors.toSet());
        int answer = 0;

        for(int i = 0; i < N - M + 1; i++) {
            if(setB.contains(A[i]) && setB.contains(A[i+1]) && setB.contains(A[i+2])) {
                answer++;
            }
        }
        System.out.println(answer);
        // Please write your code here.
    }
}