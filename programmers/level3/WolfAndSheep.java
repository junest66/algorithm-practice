import java.util.*;

class Solution {
    int[] l = new int[20]; //왼쪽 자식
    int[] r = new int[20]; //오른쪽 자식
    int[] val = new int[20]; //양, 늑대 값
    int n;
    int ans = 1;
    int[] vis = new int[1<<17]; // 2^17

    // 상태에 대한 dfs
    void solve(int state) {
        if(vis[state] == 1) return;
        vis[state] = 1;

        int wolf = 0, num = 0; // 늑대수, 전체 정점
        for(int i = 0; i < n; i++) {
            if((state & (1<<i)) != 0) { // 현재 state에서 몇번노드가 활성화됐는지  즉, 1이 몇개가 있는지
                num++;
                wolf += val[i];  //총 늑대의 수 양은 => 0이니깐 더해도 상관없음
            }
        }
        if(2*wolf >= num) { // 늑대가 절반이상차지하면 종료
            return;
        }
        ans = Math.max(ans, num - wolf); // 최대양이면 갱신

        for(int i = 0; i < n; i++) {
            if((state & (1 <<i)) == 0) continue; //0이면 정점이 없음 1일때만 다음 진행
            if(l[i] != -1) { //왼쪽 자식노드가 있으면
                solve(state | (1 <<l[i]));
            }
            if(r[i] != -1) {
                solve(state | (1 <<r[i]));
            }
        }
    }

    public int solution(int[] info, int[][] edges) {
        n = info.length;
        Arrays.fill(l, -1); //왼쪽 자식 노드 초기화
        Arrays.fill(r, -1); //오른쪽 자식 노드 초기화
        for(int i = 0; i < n; i++) {
            val[i] = info[i];
        }
        for(int i = 0; i < n-1; i++) {
            int parent = edges[i][0];
            int child = edges[i][1];
            if(l[parent] == -1) {
                l[parent] = child;
            } else {
                r[parent] = child;
            }
        }
        solve(1); // 0번 노드만 포홤된 상태에서 dfs 시작 ...xxxx1
        return ans;
    }
}
