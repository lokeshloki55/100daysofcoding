import java.util.Arrays;
import java.util.Scanner;

public class dp10_minpath_top_bottom {
    static int countwaysss(int i,int j,int[][] arr,int[][] dp)
{   
    if(i==0&&j==0)
    return arr[0][0];  //return the current element for addition and no further recursion has to be take place
    if(i<0 || j<0)
    return (int)Math.pow(10,7);// if index is beyond the range return maximum value so that path is avoided.
    if (dp[i][j]!=-1)
    return dp[i][j];
    int up=arr[i][j]+countwaysss(i-1, j, arr,dp);    //take the current element to sum and go to top element and do the same recursively
    int left=arr[i][j]+countwaysss(i, j-1, arr,dp);//take the current element to sum and go to left element and do the same recursively
    return dp[i][j]= Math.min(up,left);

}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [][] arr={{5,9,6},{11,5,2}};
        int n=arr.length;
        int m=arr[0].length;
        int [][] dp=new int[n][m];
        for(int[] eachrow:dp)
        Arrays.fill(eachrow, -1);   //array.fill works for only 1D array so we use for loop and take each row in 2d array and fill it with -1.
        System.out.println("MinPath:"+countwaysss(n-1,m-1,arr,dp));
    }}
