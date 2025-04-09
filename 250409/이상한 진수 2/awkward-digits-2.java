import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int answer = Integer.MIN_VALUE;
        for(int i = 1; i < a.length(); i++) {
            StringBuilder sb = new StringBuilder(a);
            sb.setCharAt(i, func(a.charAt(i)));
            answer = Math.max(Integer.parseInt(sb.toString(), 2), answer);
        }
        // Please write your code here.
        System.out.println(answer);
    }
    
    private static char func(char a) {
        return a == '0' ? '1' : '0';
    }
}