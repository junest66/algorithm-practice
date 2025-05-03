class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0) {
            int dig = storey % 10;
            int next = (storey / 10) % 10;

            if(dig > 5 || (dig == 5 && next >= 5)) { //캐리
                answer += 10 - dig;
                storey += 10;
            } else {
                answer += dig;
            }
            storey /= 10;
        }

        return answer;
    }
}

//95 > 6 ->
//45 > 9
