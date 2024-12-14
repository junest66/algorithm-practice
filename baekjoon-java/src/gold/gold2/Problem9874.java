package gold.gold2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem9874 {
    static Node[] wormhole;
    static int n;
    static int answer;
    static boolean[] used;
    static int[] pairs;
    static int[] nextRight;

    static class Node {
        public int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        wormhole = new Node[n];
        pairs = new int[n];
        nextRight = new int[n];
        used = new boolean[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            wormhole[i] = new Node(x, y);
        }

        Arrays.fill(pairs, -1);
        calculateNextRight(); // 오른쪽 웜홀 계산
        back(0);
        System.out.println(answer);
    }

    private static void calculateNextRight() {
        Arrays.fill(nextRight, -1);

        for (int i = 0; i < n; i++) {
            int closest = -1;
            for (int j = 0; j < n; j++) {
                if (wormhole[j].y == wormhole[i].y && wormhole[j].x > wormhole[i].x) {
                    if (closest == -1 || wormhole[j].x < wormhole[closest].x) {
                        closest = j;
                    }
                }
            }
            nextRight[i] = closest;
        }
    }

    private static void back(int pairCount) {
        // 모든 웜홀 쌍이 만들어졌다면 사이클 확인
        if (pairCount == n / 2) {
            if (checkCycle()) {
                answer++;
            }
            return;
        }

        int firstUnused = -1;
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                firstUnused = i;
                break;
            }
        }

        for (int i = firstUnused + 1; i < n; i++) {
            if (!used[i]) {
                pairs[firstUnused] = i;
                pairs[i] = firstUnused;
                used[firstUnused] = true;
                used[i] = true;

                back(pairCount + 1);

                pairs[firstUnused] = -1;
                pairs[i] = -1;
                used[firstUnused] = false;
                used[i] = false;
            }
        }
    }

    private static boolean checkCycle() {
        for (int start = 0; start < n; start++) {
            if (pairs[start] == -1) {
                continue;
            }

            int pos = start;
            boolean[] visited = new boolean[n];

            while (pos != -1) {
                if (visited[pos]) {
                    return true;
                }
                visited[pos] = true;

                int pair = pairs[pos];
                pos = nextRight[pair];
            }
        }
        return false;
    }
}
