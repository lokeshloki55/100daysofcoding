import java.util.Arrays;
import java.util.Scanner;
public class dp3_frogjump {
    public static int func(int index,int[] arr,int[] dp)
    {   int onejump,twojump;
        if(index==0)
        return dp[index]=0;//minimum energy required to reach 0th step is 0.
        if(dp[index]!=-1)
        return dp[index];

        twojump=Integer.MAX_VALUE;
        onejump=func(index-1,arr,dp)+Math.abs(arr[index]-arr[index-1]);
         if(index>=2) 
        twojump=func(index-2,arr,dp)+Math.abs(arr[index]-arr[index-2]);
        
        return dp[index]=Math.min(onejump,twojump);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=4;
        int arr[]={10,20,30,10};
        int dp[]=new int[a];
        Arrays.fill(dp,-1);   
    System.out.println(func(a-1,arr,dp));
    }
}
