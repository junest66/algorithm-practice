import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[] pulse1 = new int[n];
        int[] pulse2 = new int[n];

        for (int i = 0; i < n; i++) {
            int sign = (i % 2 == 0) ? 1 : -1;
            pulse1[i] = sequence[i] * sign;
            pulse2[i] = sequence[i] * -sign;
        }

        return Math.max(maxSubarraySum(pulse1), maxSubarraySum(pulse2));
    }

    private long maxSubarraySum(int[] arr) {
        long max = arr[0];
        long current = arr[0];

        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }

        return max;
    }
}
