package 数组相关算法;

/**
 * 给定一个 n * m 的矩阵 a，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，输出所有的路径中最小的路径和。
 * https://www.nowcoder.com/practice/7d21b6be4c6b429bb92d219341c4f8bb?tpId=190&&tqId=35224&rp=1&ru=/ta/job-code-high-rd&qru=/ta/job-code-high-rd/question-ranking
 */
public class 矩阵的最小路径和 {
    public static void main(String[] args) {
        int[][] nums = new int[][] { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(minPathSum(nums));

    }

    /**
     * @param matrix int整型二维数组 the matrix
     * @return int整型
     */
    public static int minPathSum(int[][] matrix) {
        if (matrix == null) {
            throw new IllegalArgumentException();
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[][] map = new int[n + 1][m + 1];
        for (int i = 0; i < map.length; i++) {
            map[i] = new int[m + 1];
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            m = row.length;
            for (int j = 0; j < row.length; j++) {

                map[i + 1][j + 1] =
                        i == 0 ? (map[i + 1][j] + row[j]) //第一行直接累加当前行的值就行
                                : j == 0 ? map[i][j + 1] + row[j] //第一列直接累加当前列的值
                                : Math.min(map[i][j + 1] + row[j], map[i + 1][j] + row[j]); //如果不是上面两种情况就取当前值加上列和行中的最小值
            }
        }

        return map[n][m];

    }
}
