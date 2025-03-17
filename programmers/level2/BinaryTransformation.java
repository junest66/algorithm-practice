import java.util.*;

class Solution {
    public int[] solution(String s) {
        int count = 0;
        int deleteCount = 0;
        while(!s.equals("1")) {
            count++;
            int zeroCount = calcZeroCount(s);
            System.out.println(zeroCount);
            deleteCount += zeroCount;
            int oneCount = s.length() - zeroCount;
            s = Integer.toString(oneCount, 2);
        }
        return new int[]{count, deleteCount};
    }

    private int calcZeroCount(String s) {
        int count = 0;
        for(Character c : s.toCharArray()) {
            if(c == '0') {
                count++;
            }
        }
        return count;
    }

    private int calcOne(int oneNum) {
        int total = 0;
        for(int i = 0; i < oneNum; i++) {
            total += (2 * i);
        }
        return total;
    }
}
