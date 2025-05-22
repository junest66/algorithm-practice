class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] answer = {};
        while(start < end) {
            int value = numbers[start] + numbers[end];
            if(value == target) {
                answer = new int[]{start + 1, end + 1};
                break;
            } else if(value < target) {
                start++;
            } else {
                end--;
            }
        }
        return answer;
    }
}
