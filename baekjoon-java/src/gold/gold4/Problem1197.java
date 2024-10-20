package gold.gold4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1197 {

    private static List<int[]> list = new ArrayList<>();
    private static int[] parent;
    private static int n,m;
    private static int answer = 0;
    private static int cnt = 0;

    private static void makeSet() {
        for(int i = 1; i <=n; i++) {
            parent[i] = i;
        }
    }

    private static int findSet(int a) {
        if(a == parent[a]) {
            return a;
        }
        return parent[a] = findSet(parent[a]);
    }

    private static boolean unionSet(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if(a == b) {
            return false;
        }
        if(a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.add(new int[]{dist, start, end});
        }
        makeSet();
        Collections.sort(list, (o1, o2) -> o1[0] - o2[0]);
        for(int i = 0; i < m; i++) {
            int[] current = list.get(i);
            if(!unionSet(current[1], current[2])) {
                continue;
            }
            answer += current[0];
            cnt++;
            if(cnt == n-1) {
                break;
            }
        }

        System.out.println(answer);

    }
}
