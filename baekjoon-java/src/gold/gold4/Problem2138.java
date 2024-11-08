package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2138 {
    public static String opposite(String str) {
        return str.equals("0") ? "1" : "0";
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String current = br.readLine();
        String[] currentArr1 = current.split("");
        String[] currentArr2 = current.split("");
        String goal = br.readLine();
        String[] goalArr = goal.split("");

        //0번 스위치를 눌렀을때
        currentArr1[0] = opposite(currentArr1[0]);
        currentArr1[1] = opposite(currentArr1[1]);

        int answer = 100005;
        int count1 = 1;
        int count2 = 0;

        for (int i = 1; i < n; i++) {
            if (!currentArr1[i - 1].equals(goalArr[i - 1])) {
                currentArr1[i - 1] = opposite(currentArr1[i - 1]);
                currentArr1[i] = opposite(currentArr1[i]);
                if (i + 1 != n) {
                    currentArr1[i + 1] = opposite(currentArr1[i + 1]);
                }
                count1++;
            }
            if (!currentArr2[i - 1].equals(goalArr[i - 1])) {
                currentArr2[i - 1] = opposite(currentArr2[i - 1]);
                currentArr2[i] = opposite(currentArr2[i]);
                if (i + 1 != n) {
                    currentArr2[i + 1] = opposite(currentArr2[i + 1]);
                }
                count2++;
            }
        }
        if (String.join("", currentArr1).equals(goal)) {
            answer = Math.min(answer, count1);
        }
        if (String.join("", currentArr2).equals(goal)) {
            answer = Math.min(answer, count2);
        }
        if (answer != 100005) {
            System.out.println(answer);
        } else {
            System.out.println("-1");
        }

    }
}
