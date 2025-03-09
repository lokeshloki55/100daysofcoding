import java.util.Arrays;

public class dp15_equalsumsubset {
    public static boolean subsetsum(int ind,int target,int[]arr,int[][]dp)
{
    if(target==0)  //if the target is 0 we achived the sum k
    return true;

    if(ind==0)
    return arr[0]==target; 
    
    if(dp[ind][target]!=-1)
    return (dp[ind][target]==0)?true:false;    //if 0 is present in dp array then true is returned.
   
    boolean notpick=subsetsum(ind-1, target, arr, dp);
    boolean pick =false;   
    if(arr[ind]<target)
    pick=subsetsum(ind-1, target-arr[ind], arr, dp);
    dp[ind][target]=pick||notpick?0:1;    //store 0 if true else store 1.
    return pick||notpick;  //return true if any one selection(pick,notpick) is true
}
    public static void main(String[] args) {
        int[] arr={2, 3, 3, 3, 4, 5};  
        int sum=0;
        for(int z=0;z<arr.length;z++)
        sum+=arr[z];
        int k=sum/2;
        int n=arr.length;
        int[][] dp=new int[n][k+1];
        for(int[] each:dp)
        Arrays.fill(each,-1);
        if(sum%2!=0)
        System.out.println("Subset not found.");
        else{
        boolean result=subsetsum(n-1,k,arr,dp);
        if(result)
        System.out.println("Subset found");
        else
        System.out.println("Subset not found.");}
    }
}
