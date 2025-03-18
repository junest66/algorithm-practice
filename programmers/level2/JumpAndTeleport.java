import java.util.*;

public class Solution {
    public int solution(int n) {
        return (int)Integer.toString(n, 2).replace("0", "").length();
    }
}
