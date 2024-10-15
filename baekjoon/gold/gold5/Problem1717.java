package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1717 {
    public static class Union_Find {
        int[] parent;
        int[] rank;

        public Union_Find(int size) {
            this.parent = new int[size+1];
            this.rank = new int[size+1];
            init();
        }

        public void init() {
            for (int i = 1; i < parent.length; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if(x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                if (rank[px] > rank[py]) {
                    parent[py] = px;
                } else if (rank[px] < rank[py]) {
                    parent[px] = py;
                } else {
                    parent[px] = py;
                    rank[py]++;
                }
            }
        }

        public void is_connected(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Union_Find unionFind = new Union_Find(n);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 0) {
                unionFind.union(b, c);
            } else {
                unionFind.is_connected(b, c);
            }
        }
    }
}
