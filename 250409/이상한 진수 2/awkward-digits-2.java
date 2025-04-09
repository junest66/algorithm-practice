import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder(a);
        for(int i = 1; i < a.length(); i++) {
            if(a.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                break;
            }
        }
        System.out.println(Integer.parseInt(sb.toString(), 2));
        // Please write your code here.
    }
}