import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
public class dp41_longest_increasing_subsequence {
// find the length of the longest increasing subsequence in given array.
    static int getAns(int arr[], int n, int ind, int prev_index, int[][] dp) {
        // Base condition
        if (ind == n) {
            return 0;
        }

        if (dp[ind][prev_index + 1] != -1) {
            return dp[ind][prev_index + 1];
        }

        int notTake = 0 + getAns(arr, n, ind + 1, prev_index, dp);

        int take = 0;

        if (prev_index == -1 || arr[ind] > arr[prev_index]) {
            take = 1 + getAns(arr, n, ind + 1, ind, dp);
        }

        dp[ind][prev_index + 1] = Math.max(notTake, take);   //for storing purpose only we use prev+1;

        return dp[ind][prev_index + 1]; 
    }

    public static void main(String args[]) {
        int arr[] = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;
        int dp[][] = new int[n][n + 1];  //to handle -1 in prevind n+1 is used.
        
        // Initialize dp array with -1 to mark states as not calculated yet
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        
        System.out.println("The length of the longest increasing subsequence is " + getAns(arr, n, 0, -1, dp));
        for(int[]each :dp){
            System.out.println(Arrays.toString(each));}
    }
}
