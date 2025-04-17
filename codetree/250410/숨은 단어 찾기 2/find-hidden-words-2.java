import java.util.Scanner;
public class Main {
    static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
    static int[] dx = {1, -1 ,0, 0, 1, -1, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        // Please write your code here.
        int answer = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < arr[i].length(); j++) {
                for(int k = 0; k < 8; k++) {
                    int y1 = i + dy[k] * 1;
                    int x1 = j + dx[k] * 1;
                    int y2 = i + dy[k] * 2;
                    int x2 = j + dx[k] * 2;
                    if(y1 < 0 || y2 < 0 || y1 >= n || y2 >= n) {
                        continue;
                    }

                    if(x1 < 0 || x2 < 0 || x1 >= m || x2 >= m) {
                        continue;
                    }

                    if(arr[i].charAt(j) == 'L' && arr[y1].charAt(x1) == 'E' && arr[y2].charAt(x2) == 'E') {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}