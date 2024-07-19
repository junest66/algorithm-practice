package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14891 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        TopNi[] arr = new TopNi[4];
        for (int i = 0; i < 4; i++) {
            arr[i] = new TopNi(st.nextToken());
            st = new StringTokenizer(br.readLine());
        }
        int rotationNum = Integer.parseInt(st.nextToken());
        List<RotationInfo> rotationInfos = new ArrayList<>();
        for (int i = 0; i < rotationNum; i++) {
            st = new StringTokenizer(br.readLine());
            rotationInfos.add(new RotationInfo(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
        }

        for (RotationInfo rotationInfo : rotationInfos) {
            boolean[] visit = new boolean[4];
            function(rotationInfo.number, rotationInfo.direction, visit, arr);
        }

        int answer = 0;
        if (arr[0].numbers.get(0) == 1) {
            answer += 1;
        }
        if (arr[1].numbers.get(0) == 1) {
            answer += 2;
        }
        if (arr[2].numbers.get(0) == 1) {
            answer += 4;
        }
        if (arr[3].numbers.get(0) == 1) {
            answer += 8;
        }
        System.out.println(answer);
    }

    public static void function(int number, int direction, boolean[] visit, TopNi[] arr) {
        if (visit[number]) {
            return;
        } else {
            visit[number] = true;
            int left = arr[number].getLeft();
            if (number != 0) {
                if (arr[number - 1].getRight() != left) {
                    function(number - 1, -1 * direction, visit, arr);
                } else {
                    function(number - 1, 0, visit, arr);
                }
            }
            int right = arr[number].getRight();
            if (number != 3) {
                if (arr[number + 1].getLeft() != right) {
                    function(number + 1, -1 * direction, visit, arr);
                } else {
                    function(number + 1, 0, visit, arr);
                }
            }
            if (direction == -1) {
                arr[number].counterclockwise();
            } else if (direction == 1) {
                arr[number].clockwise();
            } else {
                return;
            }
        }
    }

    public static class TopNi {
        public List<Integer> numbers = new ArrayList<>();

        public TopNi(String number) {
            for (char c : number.toCharArray()) {
                numbers.add(c - '0');
            }
        }

        int getLeft() {
            return numbers.get(6);
        }

        int getRight() {
            return numbers.get(2);
        }

        void clockwise() { //시계 방향
            numbers.add(0, numbers.remove(numbers.size() - 1));
        }

        void counterclockwise() { //반시계 방향
            numbers.add(numbers.size() - 1, numbers.remove(0));
        }
    }

    public static class RotationInfo {
        int number;
        int direction;

        public RotationInfo(int number, int direction) {
            this.number = number;
            this.direction = direction;
        }
    }
}
