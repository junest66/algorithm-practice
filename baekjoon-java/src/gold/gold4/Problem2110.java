package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2110 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        int start = 1;
        int end = list.get(list.size() - 1);
        int answer = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 1; //처음 꺼 무조건 사용
            int lastNumber = list.get(0);
            for (int i = 1; i < n; i++) {
                if (list.get(i) - lastNumber >= mid) {
                    count++;
                    lastNumber = list.get(i);
                }
            }
            if (count < c) { //덜 채움 = 너무 거리가 멈 , 줄여야함
                end = mid - 1;
            } else { // 많이채웠거나,딱맞음 = 늘려봐야함
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
