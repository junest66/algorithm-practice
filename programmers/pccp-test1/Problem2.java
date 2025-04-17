import java.util.*;
import java.util.stream.*;

class Solution {
    static int student;
    static int subject;
    static boolean[] visited;
    static int[] output;
    static int answer;
    static int[][] abilityArr;

    public int solution(int[][] ability) {

        student = ability.length;
        subject = ability[0].length;
        abilityArr = ability;
        visited = new boolean[student];
        output = new int[subject];
        func(0);

        return answer;
    }

    private void func(int depth) {

        if(depth == subject) {
            int sum = 0;
            for(int i = 0; i < output.length; i++) {
                sum += abilityArr[output[i]][i];
            }

            answer = Math.max(sum, answer);
            return;
        }

        for(int i = 0; i < student; i++) {
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = i;
                func(depth+1);
                visited[i] = false;
            }
        }
    }
}
