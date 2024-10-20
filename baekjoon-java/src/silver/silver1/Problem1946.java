package silver.silver1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1946 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new ArrayList<>());
            }
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                list.get(i).add(first);
                list.get(i).add(second);
            }

            Collections.sort(list, (o1, o2) -> o1.get(0) - o2.get(0));
            int start = list.get(0).get(1);
            int answer = 0;
            for(int i =1; i<n; i++) {
                if(list.get(i).get(1) > start) {
                    answer++;
                    continue;
                }
                start = list.get(i).get(1);
            }
            System.out.println(n-answer);

        }
    }
}
