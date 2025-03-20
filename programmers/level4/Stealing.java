class Solution {
    public int solution(int[] money) {
        int[] dp1 = new int[money.length]; //처음 터는 배열
        int[] dp2 = new int[money.length]; //마지막 터는 배열
        dp1[0] = money[0];
        dp1[1] = money[0];
        for(int i = 2; i < money.length - 1; i++) { //끝에서 두번째까지(마지막은 못텀)
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
        }

        dp2[1] = money[1];
        for(int i = 2; i < money.length; i++) { //끝까지(마지막은 털 수 있음)
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }
        return Math.max(dp1[money.length - 2], dp2[money.length-1]);
    }
}
