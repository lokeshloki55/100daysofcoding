import java.util.Arrays;
//infinte supply others are same as knapsack sum.
public class dp23_unbounded_knapsack {
    public static void main(String args[]) {
        int wg_arr[] = {2, 4, 6};   
        int val_arr[] = {5,11,13};
        int weight = 10;
        int n = wg_arr.length;
        int dp[][] = new int[n][weight + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);}
            int target,ind;
        for( target =0;target<=weight;target++){
            if(target>=wg_arr[0])
            dp[0][target]=(target/wg_arr[0])*val_arr[0];
            else
            dp[0][target]=0;
        }
        for(ind=1;ind<n;ind++)
        {
            for(target=0;target<=weight;target++)
            {
                int notpick=dp[ind-1][target];
                int pick=Integer.MIN_VALUE;
                if(wg_arr[ind]<=target)
                pick=val_arr[ind]+dp[ind][target-wg_arr[ind]];
                dp[ind][target]=Math.max(pick, notpick);
            }
        }
        System.out.println("The Maximum value of items the thief can steal with unbounded supply is " +dp[n-1][weight]);
    
}
}
