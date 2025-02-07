package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6236 {
    static int n;
    static int m;
    static int[] arr;
    static int st; // 최소는 하루 최대 금액
    static int en; // 최대는 모든 금액 합계
    static int mid;
    static int count;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringToken = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringToken.nextToken());
        m = Integer.parseInt(stringToken.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            en += arr[i];
            st = Math.max(st, arr[i]);
        }

        while (st <= en) {
            count = 1;
            mid = (st + en) / 2; // 인출 할 수 있는 잔액
            int balance = mid;
            for (int i = 0; i < n; i++) {
                if (balance < arr[i]) {
                    balance = mid;
                    count++;
                }
                balance -= arr[i];
            }

            // count 가 m보다 크거나 같다는 뜻은 인출 가격을 줄여야 카운트를 줄여야함 (최소)
            if (count <= m) { // 적다면
                en = mid - 1;
            } else {// count 가 m보다 작다 뜻은 인출 가격을 늘려야 카운트를 늘려야함
                st = mid + 1;
            }
        }
        System.out.println(st);
    }
}
