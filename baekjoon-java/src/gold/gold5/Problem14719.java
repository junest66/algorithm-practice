package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14719 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("baekjoon-java/src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        int answer = 0;
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < w - 1; i++) { //첫번째열과 마지막열은 물이 고이지 x
            int left = 0; // i번째 높이보다 큰 왼쪽 최대 높이
            int right = 0; // i번째 높이보다 큰 오른쪽 최대 높이

            for (int j = 0; j < i; j++) {
                left = Math.max(arr[j], left);
            }

            for (int j = i + 1; j < w; j++) {
                right = Math.max(arr[j], right);
            }

            if (arr[i] < left && arr[i] < right) {
                answer += Math.min(left, right) - arr[i];
            }
        }
        System.out.println(answer);
    }
}
