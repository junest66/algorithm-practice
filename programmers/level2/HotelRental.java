import java.util.*;

class Solution {
    class Time {
        int start;
        int end;

        Time(String start, String end) {
            this.start = parseTime(start);
            this.end = plusTenMinutes(parseTime(end));
        }

        @Override
        public String toString() {
            return "start : " + start + " end : " + end;
        }
    }

    private int parseTime(String time) {
        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return hour * 60 + minute;
    }

    private int plusTenMinutes(int endTime) {
        return endTime + 10;
    }
    public int solution(String[][] book_time) {
        List<Time> list = new ArrayList<>();
        for(String[] x : book_time) {
            list.add(new Time(x[0], x[1]));
        }
        Collections.sort(list, Comparator.comparing((Time t) -> t.start).thenComparing(t -> t.end));
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Time x : list) {
            // 종료해야할 방이 있는지
            while(!pq.isEmpty() && pq.peek() <= x.start) {
                pq.poll();
            }
            if(pq.size() == answer) { // 넣을 때 방을 늘려야하는지
                answer++;
            }
            pq.offer(x.end);
        }
        return answer;
    }
}
