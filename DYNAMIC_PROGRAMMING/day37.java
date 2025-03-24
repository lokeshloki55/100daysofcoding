import java.util.Arrays;
public class dp22_coins_noofways {
     public static int denomination(int ind,int target_amount,int[]arr,int[][]dp){
        if(ind==0)
        {
            if(target_amount%arr[ind]==0) //if the deomination at current index(0th index) is divisible by current remaining target then there is one way to reach target so return 1
            return dp[ind][target_amount]=1; 
             
            else
            return 0;  
        }  
        if(dp[ind][target_amount]!=-1)
        return dp[ind][target_amount];
        int pick=0;   
        int notpick=denomination(ind-1, target_amount, arr, dp);  //denomination is not picked
        if(arr[ind]<=target_amount)   // *<=* is must.
        pick=denomination(ind, target_amount-arr[ind], arr, dp); // if the denomination is picked then quantity of coins is added by "1" and stay at same index
        return dp[ind][target_amount]=pick+notpick;

    }

    public static void main(String[] args) {
     int coins[] = {1,2,3};   
        int target_amount = 4;
        int n = coins.length;
        int dp[][] = new int[n][target_amount + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);}
        System.out.println("The no.of ways to reach the target denomination:" + denomination(n - 1,target_amount,coins,dp));
}
}
