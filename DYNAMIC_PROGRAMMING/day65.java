import java.util.Arrays;
// all stocks sum we pass ind as 0.
public class dp36 {
    public static int maxprofit(int ind,int buy,int n,int[]arr,int[][]dp){
        if(ind>n-1)   //if indexes exceeds given number of days there is no more day so no profit so return 0.
        return 0;
        if(dp[ind][buy]!=-1)
        return dp[ind][buy];
        int profit=0;
        if(buy==0){
            int willbuy=maxprofit(ind+1,1,n,arr,dp)-arr[ind];    // if we buy our amount will decrease by buying price so we subtract. 
            int notbuy=0+maxprofit(ind+1,0,n,arr,dp);   //if not buy move to next day simply
            profit=Math.max(willbuy,notbuy);
        }
        else
        {
            int willsell=maxprofit(ind+1,0,n,arr,dp)+arr[ind];  // if we sell our amount will increase by selling price so we add.
            int notsell=0+maxprofit(ind+1,1,n,arr,dp);          //if not sell just move to next day.
            profit=Math.max(willsell,notsell);
        }
        dp[ind][buy]=profit;
        return profit;

    }
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {7, 1, 5, 3, 6, 4};
        int[][]dp=new int[n][2];
        for(int[] each:dp)
        Arrays.fill(each, -1);
        System.out.println("The max profit earned by buying and selling many number of times is "+maxprofit(0,0,6,arr,dp));
    }
}
