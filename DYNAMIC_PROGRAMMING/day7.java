import java.util.Arrays;
public class dp6_robber_adjacent_homes {
    private static int solveUtil(int ind, int[] arr, int[] dp) {
        if (ind < 0) return 0;   // If the index is negative,here as sum is calculated make it as 0.
        if (ind == 0) return arr[ind];   // If the index reaches 0,we can't go behind that so we can take the value at that index.
       
        if (dp[ind] != -1) return dp[ind];
        // Calculate the maximum sum by either picking the current element or not picking it.
        int pick = arr[ind] + solveUtil(ind - 2, arr, dp);//if current element is picked it's immediate previous element can't be taken.
        int nonPick = solveUtil(ind - 1, arr, dp);//if current element is not taken it's previous element can be taken
       
        return dp[ind] = Math.max(pick, nonPick);
    }
public static void main(String args[]) {
    int arr[] = {2, 1, 4, 9, 15};
    int n = arr.length;
    int dp[] = new int[n];
     Arrays.fill(dp, -1);
    int[] nottakinglastelement=Arrays.copyOfRange(arr,0, n-1);//last element of arr is omitted(copyOfRange won't last index in range)
    int[] nottakingfirstelement=Arrays.copyOfRange(arr,1, n);//first element is omitted
    System.out.println("Max amount that can stolen: "+Math.max(solveUtil(n-2,nottakingfirstelement,dp),solveUtil(n-2,nottakinglastelement,dp)));
}//finding value of both possibility and printing the max one.
}
