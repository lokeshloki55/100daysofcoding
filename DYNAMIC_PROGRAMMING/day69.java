public class dp38 {
    // here we can do k transactions.
    public static int maximumProfit(int[] prices, int n, int k) {
       
        int[][][] dp = new int[n + 1][2][k + 1];  // here n+1 is also used along with k+1(which is used in memoization so refer there.) 
        //because ind+1 is used in for loop so to avoid arraybound exception declare it to 0.        
        // As dp array is initialized to 0(default int array initialization is 0), we have already covered the base case
        
        for (int ind = n - 1; ind >= 0; ind--) {  // opposite to memoization so move from last index
            for (int buy = 0; buy <= 1; buy++) {     //other parameters are for low to high
                for (int cap = 1; cap <= k; cap++) {
                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap], 
                                -prices[ind] + dp[ind + 1][1][cap]);
                    } else { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }
        
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};//ans = 8(5-3)+(3-0)+(4-1)
        int n = prices.length;
        int k = 3;
        
        System.out.println("The maximum profit that can be generated (buy&sell atmost k times)is " + maximumProfit(prices, n, k));
    }
}
