import java.util.*;

class Solution {
    static HashMap<String, Integer> name = new HashMap<>(); // 이름 / 인덱스
    static HashMap<String, String> parent = new HashMap<>(); // 이름 / 부모이름
    static int[] won;

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        won = new int[enroll.length];
        for(int i = 0; i < enroll.length; i++) {
            name.put(enroll[i], i);
            parent.put(enroll[i], referral[i]);
        }

        for(int i = 0; i < seller.length; i++) {
            String str = seller[i];
            int price = amount[i] * 100;
            func(str, price);
        }
        return won;
    }

    public void func(String str, int price) {
        int tenPercent = (int)(0.1 * price);
        int minusPrice = price - tenPercent;
        int me = name.get(str); //본인
        //1. 자기 이득 플러스
        if(tenPercent < 1) { //1미만이면 독식
            won[me] += price; //본인 플러스
            return;
        } else {
            won[me] += minusPrice; //본인 플러스
            if(parent.get(str).equals("-")) {
                return;
            } else {
                func(parent.get(str), tenPercent);
            }
        }
    }
}
