import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int time = 0;
        Deque<Integer> que = new ArrayDeque<>();

        while(time != players.length) {
            while(!que.isEmpty() && time == que.peek()) { //서버 반납
                que.poll();
            }
            int currentPlayer = players[time];
            while((que.size() + 1) * m - 1 < currentPlayer) { //현재 서버로 감당이 안될 때 증설해야함
                que.offer(time + k);
                answer++;
            }
            time++;
        }
        return answer;
    }
}
