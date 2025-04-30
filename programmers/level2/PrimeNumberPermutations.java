import java.util.*;
import java.util.stream.*;

class Solution {
    static int n;
    static boolean[] visited;
    static int[] arr;
    static Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        n = numbers.length();
        visited = new boolean[n];
        arr = new int[n];
        String[] str = numbers.split("");
        for(int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }

        System.out.println("n :" + n);
        for (int r = 1; r <= n; r++) {
            visited = new boolean[n];
            permute(0, r, new int[r]);
        }

        return set.size();
    }

    private void permute(int depth, int r, int[] output) {
        if(r == depth) {
            result(output);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permute(depth+1, r, output);
                visited[i] = false;
            }
        }
    }

    private void result(int[] output) {
        if(output[0] == 0) {
            return;
        }
        String str = Arrays.stream(output)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        int a = Integer.parseInt(str);
        if(set.contains(a)) {
            return;
        }

        if(isPrime(a)) {
            set.add(a);
        }
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
