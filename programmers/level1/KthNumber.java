import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        return Arrays.stream(commands)
                .mapToInt(cmd -> Arrays.stream(Arrays.copyOfRange(array, cmd[0] - 1, cmd[1]))
                        .sorted()
                        .toArray()[cmd[2] - 1])
                .toArray();
    }
}
