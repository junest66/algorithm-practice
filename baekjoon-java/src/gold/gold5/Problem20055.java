package gold.gold5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem20055 {
    public static class Board {
        List<Integer> defenses = new ArrayList<>();
        List<Integer> robots = new ArrayList<>();

        public void rotate() {
            defenses.add(0, defenses.remove(defenses.size() - 1));
            for (int i = robots.size() - 1; i >= 0; i--) {
                int next = robots.get(i) + 1;
                if (next >= defenses.size() / 2 - 1) {
                    robots.remove(i);
                } else {
                    robots.set(i, next);
                }
            }
        }

        public void robotsMove() {
            for (int i = robots.size() - 1; i >= 0; i--) {
                int next = robots.get(i) + 1;
                if (!robots.contains(next) && defenses.get(next) >= 1) {
                    robots.set(i, next);
                    defenses.set(next, defenses.get(next) - 1);
                }
            }
        }

        public void initRobot() {
            if (defenses.get(0) != 0) {
                robots.add(0, 0);
                defenses.set(0, defenses.get(0) - 1);
            }
        }

        boolean isZeroWithK(int k) {
            return defenses.stream()
                    .filter(defense -> defense == 0)
                    .count() >= k;
        }

    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Board board = new Board();
        for (int i = 0; i < 2 * n; i++) {
            board.defenses.add(Integer.parseInt(st.nextToken()));
        }

        int num = 0;
        while (!board.isZeroWithK(k)) {
            num++;
            board.rotate();
            board.robotsMove();
            board.initRobot();
        }
        System.out.println(num);
    }
}
