import java.util.Arrays;
// here we have fees.
public class dp40 {
      public static int maxprofit(int ind,int buy,int n,int[]arr,int[][]dp,int fees){
        if(ind>n-1)   //if indexes exceeds given number of days there is no more day so no profit so return 0.
        return 0;
        if(dp[ind][buy]!=-1)
        return dp[ind][buy];
        int profit=0;
        if(buy==0){
            int willbuy=maxprofit(ind+1,1,n,arr,dp,fees)-arr[ind];    // if we buy our amount will decrease by buying price so we put minus. 
            int notbuy=0+maxprofit(ind+1,0,n,arr,dp,fees);   //if not buy move to next day 
            profit=Math.max(willbuy,notbuy);
        }
        else
        {
            int willsell=maxprofit(ind+1,0,n,arr,dp,fees)+arr[ind]-fees; //*ONLY CHANGE */ when we sell we deduct the fees.
            int notsell=0+maxprofit(ind+1,1,n,arr,dp,fees);          //if not sell just move to next day 
            profit=Math.max(willsell,notsell);
        }
        dp[ind][buy]=profit;
        return profit;

    }
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1,3,2,8,4,9};
        int[][]dp=new int[n][2];
        int fees=2;
        for(int[] each:dp)
        Arrays.fill(each, -1);
        System.out.println("The max profit earned by buying and selling many number of times *WITH FEES* is "+maxprofit(0,0,6,arr,dp,fees));
    }
}
