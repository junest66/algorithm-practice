import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        // Please write your code here.
        char[] arr = input.toCharArray();
        int answer = 0;
        for(int i = 0; i < arr.length - 1; i++) { // 첫번쨰 여는 괄호 찾기
            if(arr[i] == '(' && arr[i+1] == '(') {
                for(int j = i+2; j < arr.length - 1; j++) { //첫번째 닫는 괄호 찾기
                    if(arr[j] == ')' && arr[j+1] == ')') {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}