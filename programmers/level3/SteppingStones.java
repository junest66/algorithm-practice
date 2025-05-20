import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;

        //최대 몇명이 가능한가. 이분탐색
        int left = 1;
        int right = 200_000_000; //최대 돌의 값 (버틸 수 있는 사람 인원)

        while(left <= right) {
            int mid = (left + right) / 2;
            if(canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }


    private boolean canCross(int[] stones, int k, int people) {
        int skip = 0;

        for (int stone : stones) {
            if (stone < people) {
                skip++;
                if (skip >= k) return false;
            } else {
                skip = 0;
            }
        }

        return true;
    }
}
