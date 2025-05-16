import java.util.ArrayList;
import java.util.Arrays;
public class dp51_burstbaloon {
    public static int ans(ArrayList<Integer>arr,int[][]dp,int i,int j){
        if(i>j)  //NOTE:when outliers cross each other there are no points to be given.
        return dp[i][j]=0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int maxi=Integer.MIN_VALUE;
        for(int ind=i;ind<=j;ind++){   
           int curr=arr.get(i-1)*arr.get(ind)*arr.get(j+1)+ans(arr, dp, i,ind-1)+ans(arr, dp, ind+1, j); 
           if(curr>maxi)
           maxi=curr;
        }
        return dp[i][j]=maxi;
    }
    public static void main(String[] args) {
        ArrayList<Integer>arr=new ArrayList<>(Arrays.asList(3,1,5,8));
       arr.add(1);  //padding 1 at right
       arr.add(0,1);  //padding 1 at right
       int i=1;        //from 1st element only we have baloon points
       int j=arr.size()-2; //at (arr.size()-2)th place the last baloon point will be present  
       int dp[][]=new int[arr.size()][arr.size()];//dp shoud be declared after padding elements   
       for(int[] each:dp){
        Arrays.fill(each,-1);;
       }
       System.out.print("Max coins by baloon burst:"+ans(arr,dp,i,j));  
    }
}
