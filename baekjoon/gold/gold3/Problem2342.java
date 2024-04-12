package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2342 {
    static int[][] cost = new int[5][5];
    static int[][][] dp;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            list.add(n);
        }
        dp = new int[list.size()][5][5]; // 현재인덱스 , 왼발위치, 오른발 위치
        for(int i = 0; i <5; i++) {
            for(int j = 0; j < 5; j++) {
                if(i == 0) {
                    cost[i][j] = 2;
                } else if(i == j) {
                    cost[i][j] = 1;
                } else if(Math.abs(i - j) == 2) {
                    cost[i][j] = 4;
                } else {
                    cost[i][j] = 3;
                }
            }
        }

        int answer = search(0, 0, 0);
        System.out.println(answer);

    }

    private static int search(int currentIndex, int left, int right) {
        if(currentIndex == list.size()) {
            return 0;
        }
        if(dp[currentIndex][left][right] > 0) {
            return dp[currentIndex][left][right];
        }
        int nxt = list.get(currentIndex);
        int leftValue = cost[left][nxt] + search(currentIndex + 1, nxt, right);
        int rightValue = cost[right][nxt] + search(currentIndex + 1, left, nxt);
        dp[currentIndex][left][right] = Math.min(leftValue, rightValue);
        return dp[currentIndex][left][right];
    }
}
