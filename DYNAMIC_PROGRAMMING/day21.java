import java.util.Arrays;
public class dp13_ninja_twofriends {
    public static int maxchoco(int i,int j1,int j2,int n,int m,int[][]arr,int[][][]dp){
        if(j1>=m||j1<0||j2>=m||j2<0)
        return (int) (Math.pow(-10, 9));
        if(i==n-1)
        {
            if(j1==j2)
            return dp[i][j1][j2]=arr[i][j1];
            else
            return dp[i][j1][j2]=arr[i][j1]+arr[i][j2];
        }
        if (dp[i][j1][j2] != -1)
        return dp[i][j1][j2];
        int fr1,fr2,current_max,maxi=Integer.MIN_VALUE;
        for(fr1=-1;fr1<=1;fr1++)
        {
            for(fr2=-1;fr2<=1;fr2++){
                if(j1==j2)
                current_max=arr[i][j1]+maxchoco(i+1,j1+fr1,j2+fr2, n, m, arr, dp);
                else
                current_max=arr[i][j1]+arr[i][j2]+maxchoco(i+1,j1+fr1,j2+fr2, n, m, arr, dp);
                
              maxi=Math.max(current_max, maxi);
            }  }
         return dp[i][j1][j2]=maxi;
    }
    public static void main(String[] args) {
        int arr[][]={{2, 3, 1, 2}, {3, 4, 2, 2},{5, 6, 3, 5}};
        int n=arr.length;
        int m=arr[0].length;
        int dp[][][]=new int[n][m][m];
        for(int[][] each:dp){
          for(int[] eachrow:each)
               Arrays.fill(eachrow,-1);   
         }   
        System.out.println("Max chocolates:"+maxchoco(0,0,m-1,n,m,arr,dp));
    }   }
    

