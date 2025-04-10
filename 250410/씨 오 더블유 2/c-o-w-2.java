import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int answer = 0;
        for(int i = 0; i < str.length() - 2; i++) {
            for(int j = i + 1; j < str.length() - 1; j++) {
                for(int k = j + 1; k < str.length(); k++) {
                    if(str.charAt(i) == 'C' && str.charAt(j) == 'O' && str.charAt(k) == 'W') {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
        // Please write your code here.
    }
}