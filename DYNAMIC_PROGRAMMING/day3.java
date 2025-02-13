import java.util.Arrays;
import java.util.Scanner;
public class dp4_frog_k {
    public static int  func(int index,int[] arr,int[] dp,int k){
    int jump;
    if(index==0)
    return dp[index]=0;
    if(dp[index]!=-1)
    return dp[index];
    int minsteps=Integer.MAX_VALUE;  //initially declare a larger value.
   for(int j=1;j<=k;j++)  //minimum-one jump,maximum-k jumps
   {
    if(index>=j){   
    jump=func(index-j,arr,dp,k)+Math.abs(arr[index]-arr[index-j]);
    minsteps=Math.min(minsteps,jump);  
        }
   }
   return dp[index]=minsteps;
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter total number of steps and the k value(no.of steps:jumped at a time)");
        int a=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[a];
        int dp[]=new int[a];
        for(int i=0;i<a;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.fill(dp,-1);    
    System.out.println(func(a-1,arr,dp,k));
    }
}
