import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Integer num = Integer.parseInt(a, 2);
        int answer = -1;

        for(int i = a.length()- 1; i >= 0; i--) {
            answer = Math.max(num ^ (1 << i), answer);
        }
        // for(int i = 0; i < a.length(); i++) {
        //     StringBuilder sb = new StringBuilder(a);
        //     sb.setCharAt(i, func(a.charAt(i)));
        //     answer = Math.max(Integer.parseInt(sb.toString(), 2), answer);
        // }
        // Please write your code here.
        System.out.println(answer);
    }
    
    private static char func(char a) {
        return a == '0' ? '1' : '0';
    }
}