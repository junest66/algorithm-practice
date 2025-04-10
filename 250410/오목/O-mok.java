import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[19][19];
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {
                if(arr[i][j] != 0 && func(i, j)) {
                    System.out.println(arr[answer[0]][answer[1]]);
                    System.out.println((answer[0] + 1) + " " + (answer[1] + 1));
                    return; // 바로 종료
                }
            }
        }
        System.out.println(0);
    }

    private static boolean func(int i, int j) {
        int a = arr[i][j];
        if(i - 1 >= 0 && i - 2 >= 0 && i + 1 < 19 && i + 2 < 19) {
            if(arr[i-1][j] == a && arr[i-2][j] == a && arr[i+1][j] == a & arr[i+2][j] == a) {
                answer = new int[]{i, j};
                return true;
            }
        }

        if(j - 1 >= 0 && j - 2 >= 0 && j + 1 < 19 && j + 2 < 19) {
            if(arr[i][j - 1] == a && arr[i][j - 2] == a && arr[i][j+ 1] == a & arr[i][j + 2] == a) {
                answer = new int[]{i, j};
                return true;
            }
        }

        if(i - 1 >= 0 && j - 1 >= 0 && i - 2 >= 0 && j - 2 >= 0 
        && i + 1 < 19 && j + 1 < 19 && i + 2 < 19 && j + 2 < 19) {
            if(arr[i-1][j -1] == a && arr[i-2][j-2] == a && arr[i+1][j+1] == a & arr[i+2][j+2] == a) {
                answer = new int[]{i, j};
                return true;
            }
        }
        return false;

        
    }
}