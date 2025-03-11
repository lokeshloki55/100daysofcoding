import java.util.Arrays;

public class dp16_min_diff_subsets {
    public static void main(String[] args) {
        int[] arr={ 1,2,8,11,12};//19-15=4
        int n=arr.length;
        int totsum=0,f;
        for( f=0;f<n;f++)
        totsum+=arr[f];
        boolean[][] dp=new boolean[n][totsum+1];

        for(f=0;f<n;f++)
        dp[f][0]=true;   //when target is 0 the all elemnts in that row is zero.

        if(arr[0]<=totsum)
        dp[0][arr[0]]=true;  //the element which is in 0th index and equal to target value(here target=totsum) is set as true.

        int ind,target,mini=Integer.MAX_VALUE,diff;
        for(ind=1;ind<n;ind++){
        for(target=1;target<=totsum;target++){
             boolean notpick=dp[ind-1][target];
             boolean pick =false;   
             if(arr[ind]<=target)  //*must use <= symbol */because we should also consider if the index value is equal to the target.
             pick=dp[ind-1][target-arr[ind]];//if we pick the element we must reduce the target.
             dp[ind][target]=pick||notpick;     //if any one is true the dp value is true. 
        }
        for(f=0;f<totsum;f++)   
        {
        if(dp[n-1][f]){//taking the last row of dp which contains true in places where we can make sum equal to the respective column number(target) by taking all the given elements.
            diff=Math.abs(f-(totsum-f));  //here f is the sum of first subset and(totsum-f) is the sum of another subset and we takE absolute difference.
             mini=Math.min(mini,diff);}
        }
    }
        System.out.println("Min diff subset:"+mini);
    }   
}
