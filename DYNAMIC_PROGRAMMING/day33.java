import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp20_coindenomination {
    public static int denomination(int ind, int target_amount, int[] arr, int[][] dp) {
        if (ind == 0) {
            if (target_amount % arr[ind] == 0) {
                return dp[ind][target_amount] = target_amount / arr[ind];
            } else {
                return dp[ind][target_amount] = Integer.MAX_VALUE / 2; // Large value to avoid this path
            }
        }

        if (dp[ind][target_amount] != -1)
            return dp[ind][target_amount];

        int notpick = denomination(ind - 1, target_amount, arr, dp);
        int pick = Integer.MAX_VALUE;
        if (arr[ind] <= target_amount) {
            pick = 1 + denomination(ind, target_amount - arr[ind], arr, dp);
        }

        return dp[ind][target_amount] = Math.min(pick, notpick);
    }

    public static void findSubsets(int ind, int target, int[] arr, int[][] dp, List<Integer> currentSubset, List<List<Integer>> allSubsets) {
        if (target == 0) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }
    
        // If index is out of bounds or target is negative, no valid subset can be formed
        if (ind < 0 || target < 0) {
            return;
        }
    
        // Include the current coin (ind-th coin) and recursively find subsets
        if (arr[ind] <= target) {
            currentSubset.add(arr[ind]);
            findSubsets(ind, target - arr[ind], arr, dp, currentSubset, allSubsets); //**** */ Notice we are not decrementing index
            currentSubset.remove(currentSubset.size() - 1);
        }
    
        // Exclude the current coin and move to the next
        findSubsets(ind - 1, target, arr, dp, currentSubset, allSubsets);
    }


    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target_amount = 7;
        int n = coins.length;
        int[][] dp = new int[n][target_amount + 1]; 
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int minCoins = denomination(n - 1, target_amount, coins, dp);
        List<List<Integer>> allSubsets = new ArrayList<>();
        findSubsets(n-1,target_amount,coins,dp,new ArrayList<>(),allSubsets);

        System.out.println("The minimum number of coins needed to achieve the target denomination: " + minCoins);
        for(List<Integer>each:allSubsets)
        System.out.println("Coins used: " + each);
        
    }
}
