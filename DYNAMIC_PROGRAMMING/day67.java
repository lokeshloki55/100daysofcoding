import java.util.Arrays;
// we can do only 2 transactions (when one buy&sell completes then it is counted as one transaction)
public class dp37 {
    public static int maxprofit(int ind,int buy,int count,int n,int[]arr,int[][][]dp){
        if(ind>n-1||count==0)  //if indexes exceeds given number of there is no more day no profit so return 0.(or) 
                                //if the number of transactions(count) reaches 0 we can do any buy/sell so we cant make profit anymore.
        return 0;
        if(dp[ind][buy][count]!=-1)
        return dp[ind][buy][count];
        int profit=0;
        if(buy==0){
            int willbuy=maxprofit(ind+1,1,count,n,arr,dp)-arr[ind];  // if we buy our amount will decrease by buying price so subtract. 
            int notbuy=0+maxprofit(ind+1,0,count,n,arr,dp);
            profit=Math.max(willbuy,notbuy);
        }
        else
        {
            int willsell=maxprofit(ind+1,0,count-1,n,arr,dp)+arr[ind];  // when sell is completed one transaction in completed so decrease count by 1. 
            // if we sell our amount will increase by selling price so we add.
            int notsell=0+maxprofit(ind+1,1,count,n,arr,dp);
            profit=Math.max(willsell,notsell);
        }
        dp[ind][buy][count]=profit;
        return profit;
    }
    public static void main(String[] args) {
       
        int[] arr = {3,3,5,0,0,3,1,4};
        int n=arr.length;
        int count=2;     // maximum allowed transactions.
        int[][][]dp=new int[n][2][count+1];  // count+1 (because we have process upto count=0)
        for(int [][]eacheach:dp){
        for(int[] each:eacheach)
        Arrays.fill(each, -1);}
        System.out.println("The max profit earned by buying and selling atmost 2 times is "+maxprofit(0,0,count,n,arr,dp));
    }
}
