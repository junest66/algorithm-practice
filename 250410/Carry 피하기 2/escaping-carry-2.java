import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = -1;
        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = i +1; j < arr.length - 1; j++) {
                int a = arr[i] + arr[j];
                if(func(arr[i], arr[j])) {
                    for(int k = j + 1; k < arr.length; k++) {
                        if(func(a, arr[k])) {
                            answer = Math.max(answer, a + arr[k]);
                        }
                    }
                }
            }
        }
        System.out.println(answer);
        // Please write your code here.
    }

    private static boolean func(int i, int j) {
        String a = Integer.toString(i);
        String b = Integer.toString(j);

        int as = a.length() -1;
        int bs = b.length() - 1;
        while(as >= 0 && bs >= 0) {
            if(a.charAt(as) - '0' + b.charAt(bs) - '0' >= 10) {
                return false;
            }
            as--;
            bs--;
        }
        return true;
    }
}