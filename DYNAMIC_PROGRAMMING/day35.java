import java.util.Arrays;

public class dp21_assigning_sign {
    public static int ways(int ind,int target,int[]arr,int[][]dp){
if(ind == 0){
    if(target==0 && arr[0]==0)
        return 2;
    if(target==0 || target == arr[0])
        return 1;
    return 0;
}
    if(dp[ind][target]!=-1)
    return dp[ind][target];

     int pick=0;
     int notpick=ways(ind-1, target, arr, dp);
     if(arr[ind]<=target)
     pick=ways(ind-1, target-arr[ind], arr, dp);
    
     return dp[ind][target]=pick+notpick;
     
    }
    public static void main(String[] args) {
    int[] arr={ 1,2,3,1};  //{-++-}&{+-++}=2 ways
    int n=arr.length;
    int target_value=3,totsum=0;
    for (int i = 0; i < arr.length; i++) {
        totsum += arr[i];
    }
    int reqsum=(totsum-target_value)/2; 
   
    if((totsum-target_value)%2!=0 || (totsum-target_value)<0)  //for these conditions  subsets can't be found.
    {
        System.out.println("0 ways");
        System.exit(0);
    }
    int[][] dp=new int[n][reqsum+1];
    for (int i = 0; i < n; i++) {
    Arrays.fill(dp[i], -1);
}
    System.out.println("No.of ways:"+ways(n-1,reqsum,arr,dp));
    }
}
