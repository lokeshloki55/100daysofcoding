import java.util.Arrays;
import java.util.Scanner;
public class dp8_topleft_bottomright {
    static int countways(int i,int j,int[][] arr)
{
    if(i==0&&j==0)
    return 1;//one way is found.
    if(i<0 || j<0)
    return 0;// if index is beyond the range then we can return 0.
    if (arr[i][j]!=-1)
    return arr[i][j];
    int up=countways(i-1, j, arr);
    int left=countways(i, j-1, arr);
    return arr[i][j]= up+left;

}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter rows and columns:");
        int m=sc.nextInt();
        int n=sc.nextInt();
        int [][] arr=new int[m][n];
        for(int[] eachrow:arr)
        Arrays.fill(eachrow, -1);   
        System.out.println("No. of ways:"+countways(m-1,n-1,arr));
    }}
