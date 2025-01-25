package silver.silver2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12891 {
    static int n;
    static int m;
    static int[] arr = new int[4];
    static int[] myArr;
    static int checkSecret = 0;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[] a = br.readLine().toCharArray();
        myArr = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] == 0) {
                checkSecret++;
            }
        }
        int count = 0;

        for (int i = 0; i < m; i++) {
            add(a[i]);
        }
        if (checkSecret == 4) {
            count++;
        }
        for (int i = m; i < n; i++) {
            add(a[i]);
            sub(a[i - m]);
            if (checkSecret == 4) {
                count++;
            }
        }
        System.out.println(count);

    }

    private static void sub(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == arr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == arr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == arr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == arr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == arr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == arr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == arr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == arr[3]) {
                    checkSecret++;
                }
                break;
        }
    }
}
