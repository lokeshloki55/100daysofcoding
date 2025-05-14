import java.util.Arrays;
//Given a chain of matrices A1,..., An denoted by an array of size n+1, find out the minimum number of operations to multiply these n matrices.
public class dp48_mcm {
    public static int mcmm(int[] arr,int dp[][],int i,int j){
        if (i==j)  // only one matrix is left and to multiply one matrix th operations required is 0.
        return dp[i][j]=0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){   //NOTE
            int curr=mcmm(arr,dp,i,k)+mcmm(arr,dp,k+1,j)+(arr[i-1]*arr[k]*arr[j]);  //NOTE
            if(curr<mini)
            mini=curr;
        }
        return dp[i][j]=mini;
    }
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int dp[][]=new int[arr.length][arr.length];  //no extra lengths needed.
         for(int [] each:dp){
            Arrays.fill(each,-1);
         }
        int i=1;                  //NOTE
        int j=arr.length-1;
        System.out.println("minimum operations required to multiply these matrices is "+mcmm(arr,dp,i,j));
    }
}
