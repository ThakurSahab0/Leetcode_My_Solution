   class Solution {
        public int minFallingPathSum(int[][] matrix) {
            int n = matrix.length;
            int[][] dp = new int[n + 1][n + 2];

            // The DP walls should be out-of-scope hence Integer.MAX_VALUE; They are used for code ease
            for (int r = 0; r < dp.length; r++) {
                dp[r][0] = Integer.MAX_VALUE;
                dp[r][dp[0].length - 1] = Integer.MAX_VALUE;
            }

            for (int r = n - 1; r >= 0; r--) {
                for (int c = 0; c < n; c++) {
                    int[] moves = new int[]{dp[r + 1][c], dp[r + 1][c + 1], dp[r + 1][c + 2]};
                    dp[r][c + 1] = matrix[r][c] + Arrays.stream(moves).min().getAsInt();
                }
            }
            
            return Arrays.stream(dp[0]).min().getAsInt();

        }
    }