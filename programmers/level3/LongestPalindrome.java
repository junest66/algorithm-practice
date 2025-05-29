class Solution
{
    public int solution(String s)
    {
        int answer = 1; //제일 작은 팰린드롬 (자기 자신)
        int n = s.length();
        for(int i = 0; i < n; i++) { // i는 중심점 -> 중심정므로 좌우로 이동
            for(int j = 0; j < 2; j++) {
                int left = i;
                int right = i + j;
                while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                    if(answer < right - left + 1) {
                        answer = right - left + 1;
                    }
                    left--;
                    right++;
                }
            }
        }

        return answer;
    }
}
