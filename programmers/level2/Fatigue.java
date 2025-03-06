class Solution {
    static int[][] arr;
    static int n;
    static int answer;
    static boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        arr = dungeons;
        n = dungeons.length;
        visited = new boolean[n];
        back(k, 0);
        return answer;
    }

    private void back(int piro, int count) {
        for (int i = 0; i < n; i++) {
            if (!visited[i] && arr[i][0] <= piro) {
                visited[i] = true;
                back(piro - arr[i][1], count + 1);
                answer = Math.max(answer, count + 1);
                visited[i] = false;
            }
        }
    }
}
