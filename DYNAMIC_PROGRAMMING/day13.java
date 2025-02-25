import java.util.Arrays;
import java.util.Scanner;

public class dp9_obstacle_top_bottom {
    static int countways(int i,int j,int[][] arr,int[][] dp)
{   if (j>=0&&i>=0&&arr[i][j]==-1)   //if i and j is in index range also obstacle is present.
    return 0;
    
    if(i==0&&j==0)
    return 1;  //one way is found.
    
    if(i<0 || j<0)
    return 0;// if index is beyond the range there is no way.
    if (dp[i][j]!=-1)
    return dp[i][j];
    int up=countways(i-1, j, arr,dp);
    int left=countways(i, j-1, arr,dp);
    return dp[i][j]= up+left;

}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [][] arr={{0,0,0},{0,-1,0},{0,0,0}};
        int [][] dp=new int[3][3];
        for(int[] eachrow:dp)
        Arrays.fill(eachrow, -1);   //array.fill works for only 1D array so we use for loop and take each row in 2d array and fill it with -1.
        System.out.println("No.of ways:"+countways(2,2,arr,dp));
    }
}
