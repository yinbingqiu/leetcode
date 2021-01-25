import java.util.Stack;

public class 任意进制转化 {
    /**
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve(int M, int N) {
        String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (N < 2 || N > 26) {
            throw new IllegalArgumentException();
        }

        if (M == 0) {
            return "0";
        }
        boolean fushu = false;
        if (M < 0) {
            M = -M;
            fushu = true;
        }
        Stack<String> stack = new Stack<>();

        while (M != 0) {
            stack.push(String.valueOf(s.charAt(M % N)));
            M = M / N;
        }
        StringBuilder builder = new StringBuilder();
        if (fushu) {
            builder.append("-");
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();

    }
}
