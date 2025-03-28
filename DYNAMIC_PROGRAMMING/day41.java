import java.util.*;

public class dp24_rodcutting {
    static int rod(int[] wt, int[] val, int ind, int W, int[][] dp) {
   
        if (ind == 0) {
            return ((int) (W / wt[0])) * val[0];
        }

        if (dp[ind][W] != -1)
            return dp[ind][W];
        int notTaken = 0 + rod(wt, val, ind - 1, W, dp);
        int taken = Integer.MIN_VALUE;

        if (wt[ind] <= W)
            taken = val[ind] + rod(wt, val, ind, W - wt[ind], dp);
        return dp[ind][W] = Math.max(notTaken, taken);
    }
    public static void main(String args[]) {
        int wt[] = {1,2,3,4,5};
        int val[] = { 2,5,7,8,10 };
        int W = 5;
        int n = wt.length;
        int[][] dp = new int[n][W + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        System.out.println("The Max value is " + rod(wt, val, n - 1, W, dp));
    }
}



