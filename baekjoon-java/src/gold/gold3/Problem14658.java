package gold.gold3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14658 {
    public static List<Star> stars = new ArrayList<>();
    public static int n;
    public static int m;
    public static int l;
    public static int k;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new Star(x, y));
        }
        int answer = 0;
        for (int i = 0; i < stars.size(); i++) {
            Star now = stars.get(i);
            for (int j = now.x - l; j <= now.x; j++) {
                int y = now.y;
                if (j < 0) {
                    continue;
                }
                int cnt = 0;
                for (int q = 0; q < k; q++) {
                    Star check = stars.get(q);
                    if (j <= check.x && check.x <= j + l && y <= check.y && check.y <= y + l) {
                        cnt++;
                    }
                }
                answer = Math.max(cnt, answer);
            }
        }
        System.out.println(k - answer);
    }

    public static class Star {
        int x;
        int y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
