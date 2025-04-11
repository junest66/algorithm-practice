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
        
        Map<Integer, Long> map = Arrays.stream(B).boxed().collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        int answer = 0;

        for(int i = 0; i < N - M + 1; i++) {
            Map<Integer, Long> temp = new HashMap<>(map);
            boolean isPass = true;
            for(int j = i; j < i + M; j++) {
                if(temp.containsKey(A[j])) {
                    if(temp.get(A[j]) > 1) {
                        temp.put(A[j], temp.get(A[j]) - 1);
                    } else {
                        temp.remove(A[j]);
                    }
                } else {
                    break;
                }
            }

            if(temp.isEmpty()) {
                answer++;
            }
        }
        System.out.println(map);
        System.out.println(answer);
        // Please write your code here.
    }
}