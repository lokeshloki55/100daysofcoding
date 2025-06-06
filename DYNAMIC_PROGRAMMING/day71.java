import java.util.Arrays;
public class dp39 {
    // there should be one day gap after sell and before next buy.
    static int getAns(int[] Arr, int ind, int buy, int n, int[][] dp) {
        // Base case
        if (ind >= n) {
            return 0;
        }
        if (dp[ind][buy] != -1) {
            return dp[ind][buy];   // If the result is already calculated, return it
        }
        int profit = 0;
        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 0, n, dp),
                    -Arr[ind] + getAns(Arr, ind + 1, 1, n, dp));
        }
        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, ind + 1, 1, n, dp),Arr[ind] + getAns(Arr, ind + 2, 0, n, dp));//NOTE 1 day extra when sell
        }
        // Store the result in dp and return it
        dp[ind][buy] = profit;
        return profit;
    }
    static int stockProfit(int[] Arr) {
        int n = Arr.length;
        int[][] dp = new int[n][2];
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int ans = getAns(Arr, 0, 0, n, dp);
        return ans;
    }

    public static void main(String args[]) {
        int prices[] = {4, 9, 0, 4, 10};
        System.out.println("The maximum profit that can be generated is " + stockProfit(prices));
    }}
