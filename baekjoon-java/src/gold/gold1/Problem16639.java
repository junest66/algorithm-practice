package gold.gold1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem16639 {
    static int answer = 0;
    static int n;
    static int[][] min, max;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        min = new int[n][n];
        max = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(min[i], Integer.MAX_VALUE);
            Arrays.fill(max[i], Integer.MIN_VALUE);
        }
        char[] input = br.readLine().toCharArray();
        for (int i = 0; i < n; i += 2) {
            min[i][i] = input[i] - '0';
            max[i][i] = input[i] - '0';
        }

        for (int j = 2; j < n; j += 2) {
            for (int i = 0; i < n - j; i += 2) {
                for (int k = 2; k <= j; k += 2) {
                    char op = input[i + k - 1];
                    int[] tmp = new int[4];
                    tmp[0] = calculate(max[i][i + k - 2], max[i + k][i + j], op);
                    tmp[1] = calculate(min[i][i + k - 2], max[i + k][i + j], op);
                    tmp[2] = calculate(max[i][i + k - 2], min[i + k][i + j], op);
                    tmp[3] = calculate(min[i][i + k - 2], min[i + k][i + j], op);
                    Arrays.sort(tmp);
                    max[i][i + j] = Math.max(max[i][i + j], tmp[3]);
                    min[i][i + j] = Math.min(min[i][i + j], tmp[0]);
                }
            }
        }
        System.out.println(max[0][n - 1]);
    }

    private static int calculate(int n1, int n2, char op) {
        int res = 0;
        switch (op) {
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
            case '*':
                res = n1 * n2;
                break;
        }
        return res;
    }
}
