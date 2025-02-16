import java.util.Arrays;

public class dp5_maxsum_of_nonadjacent_elements {
     private static int solveUtil(int ind, int[] arr, int[] dp) {
        // If the index is negative,we return 0.
        if (ind < 0) return 0;  
        // If the index arrives 0,we cant go behind that so take the value at that index.
        if (ind == 0) return arr[ind];  
       
        if (dp[ind] != -1) return dp[ind];
        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = arr[ind] + solveUtil(ind - 2, arr, dp);//if current element is picked it's immediate previous element can't be taken so ind-2 element is taken.
        int nonPick = solveUtil(ind - 1, arr, dp);//if current element is not taken, it's previous element can be taken
       
        return dp[ind] = Math.max(pick, nonPick);
    }
public static void main(String args[]) {
    int arr[] = {2, 1, -4, 9,-9,10,11};
    int n = arr.length;
    int dp[] = new int[n];
     Arrays.fill(dp, -1);
    System.out.println("Maximum sum of non adjacent elements:"+solveUtil(n-1, arr,dp));
}
}
