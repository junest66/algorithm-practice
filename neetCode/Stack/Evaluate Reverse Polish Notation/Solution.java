class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stk = new ArrayDeque<>();
        Set<String> op = Set.of("+", "-", "*", "/");
        for(String str : tokens) {
            if(op.contains(str)) { //연산자인 경우
                int b = stk.pop();
                int a = stk.pop();
                stk.push(calc(a, b, str));
            } else {
                stk.push(Integer.parseInt(str));
            }
        }
        return stk.pop();
    }

    private int calc(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
            default:
                return 0;
        }
    }
}
