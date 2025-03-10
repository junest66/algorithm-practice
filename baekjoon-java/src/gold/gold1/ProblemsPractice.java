package gold.gold1;

import java.util.Arrays;

public class ProblemsPractice {
    static int[] nums = {1, 2, 3, 4, 5, 6, 7}; // 주어진 숫자 배열
    static int[] output = new int[4]; // 뽑을 숫자 저장
    static int k = 4; // 조합 크기

    public static void main(String[] args) {
//        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int sum = Arrays.stream(numbers).filter(n -> n % 2 == 0)
//                .sum();
//        System.out.println("sum = " + sum);

//        int[] numbers = {1, 2, 2, 3, 4, 4, 5, 6, 6, 7};
//        int[] array = Arrays.stream(numbers).distinct().toArray();
//        int[] numbers = {13, 42, 7, 99, 25, 64};
//        int asInt = Arrays.stream(numbers).max().getAsInt();
//        System.out.println("asInt = " + asInt);

//        int[] numbers = {1, 2, 3, 4, 5};
//        int[] array = Arrays.stream(numbers).map(n -> n * n).toArray();
//        System.out.println(Arrays.toString(array));

//        String[] words = {"apple", "banana", "pear", "grape", "cherry"};
//        Map<Integer, List<String>> collect = Arrays.stream(words)
//                .collect(Collectors.groupingBy(n -> n.length()));
//        System.out.println("collect = " + collect);

//        int[] numbers = {10, 20, 30, 40, 50};
//        double asDouble = Arrays.stream(numbers).average().getAsDouble();
//        System.out.println("asDouble = " + asDouble);

//        int[] numbers = {1, 2, 3};
//        String[] array = Arrays.stream(numbers).mapToObj(n -> "숫자: " + n).toArray(String[]::new);
//        System.out.println(Arrays.toString(array));

//        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 5, 5};
//        Map<Integer, Long> collect = Arrays.stream(numbers).boxed()
//                .collect(Collectors.groupingBy(n -> n, Collectors.counting()));
//        Long max = Collections.max(collect.values());
//        List<Long> collect1 = collect.entrySet().stream().filter(n -> n.getValue() == max).map(Entry::getValue)
//                .collect(Collectors.toList());
//        System.out.println("collect1 = " + collect1);

//        String[] words = {"banana", "apple", "grape", "cherry"};
//        String[] array = Arrays.stream(words).sorted((Comparator.comparingInt(String::length))).toArray(String[]::new);
//        System.out.println(Arrays.toString(array));
//        String[] words = {"banana", "apple", "grape", "mango"};
//        String[] array = Arrays.stream(words).filter(n -> n.contains("an")).toArray(String[]::new);
//        System.out.println(Arrays.toString(array));

//        combination(0, 0);
    }
//
//    private static void combination(int depth, int start) {
//        if (depth == k) { // 조합이 완성된 경우 출력
//            for (int i = 0; i < output.length; i++) {
//                System.out.print(output[i] + " ");
//            }
//            System.out.println(); // 줄 바꿈
//            return; // ✅ 재귀 종료
//        }
//
//        for (int i = start; i < nums.length; i++) {
//            output[depth] = nums[i]; // 현재 숫자를 저장
//            combination(depth + 1, i + 1); // 다음 숫자 선택 (이전 숫자보다 큰 값만 선택)
//        }
//    }
}
