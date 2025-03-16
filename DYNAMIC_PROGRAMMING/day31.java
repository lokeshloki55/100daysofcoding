import java.util.Arrays;
public class dp19_knapsnack {
 static int knapsackUtil(int[] wg_arr, int[] val_arr, int ind, int weight, int[][] dp) {
        if (ind == 0) {
            if (wg_arr[0] <= weight) {
                // take element in arr[0] if it is less than remaining weight because if we take that it will maximize the value.
                return val_arr[0];
            } else {
                // Otherwise, exclude the item
                return 0;
            }
        }
        if (dp[ind][weight] != -1) {
            return dp[ind][weight];
        }
        int notTaken = 0 + knapsackUtil(wg_arr, val_arr, ind - 1, weight, dp);
        int taken = Integer.MIN_VALUE;
        if (wg_arr[ind] <= weight) {
            taken = val_arr[ind] + knapsackUtil(wg_arr, val_arr, ind - 1, weight - wg_arr[ind], dp);
        }

        // Store and return the result for the current state
        dp[ind][weight] = Math.max(notTaken, taken);
        return dp[ind][weight];
    }
    public static void main(String args[]) {
        int wg_arr[] = {1, 2, 4, 5};   //ans:{1+4=5}&{5+8=13}
        int val_arr[] = {5, 4, 8, 6};
        int weight = 5;
        int n = wg_arr.length;
        int dp[][] = new int[n][weight + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);}
        System.out.println("The Maximum value of items the thief can steal is " + knapsackUtil(wg_arr, val_arr, n - 1, weight, dp));
    
    
}
}
