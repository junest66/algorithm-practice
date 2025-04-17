import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String input_string) {
        int[] arr = new int[26];

        char[] c = input_string.toCharArray();

        for(int i = 0; i < c.length; i++) {
            if(i == 0 || c[i] != c[i-1]) {
                arr[c[i] - 'a']++;
            }
        }
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= 2) {
                int a = i+'a';
                answer.append((char)a);
            }
        }
        return answer.length() == 0 ? "N" : answer.toString();
    }
}
