import java.util.*;
import java.util.stream.*;

class Solution {
    public long[] solution(int[][] program) {
        long[] answer = new long[11]; // answer[0]: 종료시간, answer[i]: 점수 i의 대기시간 합

        Arrays.sort(program, Comparator.comparingInt(p -> p[1])); // 프로그램 호출된 시각 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0]; // 점수 높은 순
            if(a[1] != b[1]) return a[1] - b[1]; // 요청시간 빠른 순
            return a[2] - b[2];
        });

        int time = 0;
        int idx = 0;

        while(idx < program.length || !pq.isEmpty()) {

            // 현재 시간까지 도착한 프로그램 넣기
            while(idx < program.length && program[idx][1] <= time) {
                pq.offer(program[idx]);
                idx++;
            }

            if(!pq.isEmpty()) { //큐에 넣어진 프로그램 실행
                int[] cur = pq.poll();
                int waitTime = time - cur[1]; // 현재시각 - 호출된 시간
                answer[cur[0]] += waitTime; //점수별 대기시간 누적
                time += cur[2]; //시간 플러스
            } else {
                time = program[idx][1];
            }
        }
        answer[0] = time;
        return answer;
    }
}
