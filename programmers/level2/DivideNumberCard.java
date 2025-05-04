class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int resultA = func(arrayA, arrayB);
        int resultB = func(arrayB, arrayA);
        return Math.max(resultA, resultB);
    }

    private int func(int[] baseArray, int[] otherArray) {
        int g = baseArray[0];
        for (int i = 1; i < baseArray.length; i++) {
            g = gcd(g, baseArray[i]);
        }

        for (int num : otherArray) {
            if (num % g == 0) return 0;
        }

        return g;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
