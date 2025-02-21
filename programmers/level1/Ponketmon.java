import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int start = nums.length / 2;

        if(set.size() >= start) {
            return start;
        } else {
            return set.size();
        }
    }
}
