import java.util.*;

class Solution {
    static int[] parent;

    public void init(int n) {
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if(parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) {
            return false;
        }
        parent[pb] = pa;
        return true;
    }

    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        init(n);
        int count = 0;
        int sum = 0;
        for(int[] x: costs) {
            if(count == n-1) {
                break;
            }
            if(union(x[0], x[1])) {
                count++;
                sum += x[2];
            }
        }
        return sum;
    }
}
