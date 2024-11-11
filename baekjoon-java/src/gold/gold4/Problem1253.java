package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1253 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int start = 0;
            int end = arr.length - 1;
            int sum = 0;
            while (start < end) {
                sum = arr[start] + arr[end];
                if (sum == target) {
                    if (i == start) { // 타켓 인덱스 사용한 경우
                        start++;
                    } else if (i == end) { // 타켓 인덱스 사용한 경우
                        end--;
                    } else {
                        answer++;
                        break;
                    }
                }
                if (arr[start] + arr[end] > target) { // 타켓보다 큰 경우
                    end--;
                } else if (arr[start] + arr[end] < target) { //타켓보다 작은 경우
                    start++;
                }
            }
        }
        System.out.println(answer);
    }
}
