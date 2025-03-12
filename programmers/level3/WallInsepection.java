import java.util.*;

class Solution {
    private static int length, answer;
    private static int[] Weak;
    private static boolean[] used;

    public int solution(int n, int[] weak, int[] dist) {
        length = weak.length; // 취약지점 갯수
        Weak = new int[length * 2]; // 선형
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < weak.length; j++) {
                Weak[j + (i * length)] = weak[j] + (i * n);
            }
        }

        Arrays.sort(dist);
        answer = -1;
        used = new boolean[dist.length];

        for(int i = 1; i <= dist.length; i++) { //i명씩 뽑음
            int[] org = new int[i];
            System.arraycopy(dist, dist.length - i, org, 0, i); // org에 가장 범위가 큰 친구를 뽑음
            backtrack(0, new int[i], org);
            if(answer > 0) {
                break;
            }
        }

        return answer;
    }

    private void backtrack(int n, int[] dist, int[] org) { //org 배열의 순열 ex) 234, 243, 423, 432, 324, 342
        if(n == org.length) { // org
            if(check(dist)) {
                answer = n;
            }
            return;
        }

        for(int i = 0; i < org.length; i++) {
            if(!used[i]) {
                used[i] = true;
                dist[n] = org[i];
                backtrack(n+1, dist, org);
                used[i] = false;
            }
        }
    }

    private boolean check(int[] dist) {
        for(int i = 0; i < length; i++) {
            int start = i; //시작 취약지점
            for(int distance : dist) {
                int pos = Weak[start++] + distance;
                while(start < Weak.length && Weak[start] <= pos) {
                    start++;
                }
            }
            if(start - i >= length) {
                return true;
            }
        }
        return false;
    }
}
