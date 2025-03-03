import java.util.Arrays;
public class dp12_2d_anystartpoint_anyendpoint {
    public static int maxpath(int i,int j,int[][] arr,int[][] dp,int m){
        if(j<0||j>=m)  
        return -22222;
        if(i==0)
        return arr[i][j];
        if(dp[i][j]!=-1)
        return dp[i][j];
        int up=arr[i][j]+maxpath(i-1, j, arr, dp,m);
        int leftdia=arr[i][j]+maxpath(i-1, j-1, arr, dp,m);
        int rightdia=arr[i][j]+maxpath(i-1, j+1, arr, dp,m);
        return dp[i][j]=Math.max(up,Math.max(leftdia,rightdia));
    }
    public static void main(String[] args) {
        int arr[][]={{1,2,10,4},{100,3,2,1},{1,1,20,2},{1,2,2,1}};
        int n=arr.length;
        int m=arr[0].length;
        int dp[][]=new int[n][m];
        for(int[] eachrow:dp)
        Arrays.fill(eachrow,-1);
        int maxi=Integer.MIN_VALUE;
        int current_max;
        for(int k=0;k<m;k++){
            current_max=maxpath(n-1,k,arr,dp,m);
            maxi=Math.max(current_max,maxi);
        }
        System.out.println("Maximum path sum:"+maxi);
    }}
