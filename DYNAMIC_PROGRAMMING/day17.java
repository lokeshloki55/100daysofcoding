import java.util.Arrays;
import java.util.Scanner;

public class dp11_triangle_minpathsum {
    public static int minpath(int i,int j,int[][]arr,int[][] dp,int row)
    {
        if(i==row-1)  //reached last index
        return arr[i][j];
        if(dp[i][j]!=-1)
        return dp[i][j];
       int down=arr[i][j]+minpath(i+1, j, arr, dp, row);
       int diagonal=arr[i][j]+minpath(i+1, j+1, arr, dp, row);
        return dp[i][j]=Math.min(down,diagonal);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("No of rows & columns:");
        int row =sc.nextInt();
        int col=sc.nextInt();
        int[][] arr=new int[row][];
        for(int i=0;i<row;i++)
        {
           arr[i]=new int[i+1];
           for(int j=0;j<=i;j++)
           {
            arr[i][j]=sc.nextInt();
           }
        }
        int[][] dp=new int[row][col];
        for(int[] eachrow:dp)
        Arrays.fill(eachrow, -1);
        System.out.println("Min path:"+minpath(0,0,arr,dp,row));
    }
}
