import java.util.Arrays;
public class dp7_ninja {
    public static int calc(int day,int lasttask,int[][] arr,int[][] dp)
    {
        if(day<0)
        return 0;
        
        int maxi=0;
        if(dp[day][lasttask]!=-1){
            return dp[day][lasttask];
        }
        
     
    for(int curr_task=0;curr_task<=2;curr_task++)
    {
        if(curr_task!=lasttask)
        {
            int maxi_curr=calc(day-1, curr_task, arr, dp)+arr[day][curr_task];
            maxi=Math.max(maxi,maxi_curr);
        }
    }
     return dp[day][lasttask]=maxi;
}
    public static void main(String[] args) {
        int [][] arr={{10,40,70},{20,50,80},{30,60,90}};
        int [][] dp=new int[3][4];
        for(int[] eachrow:dp)
        Arrays.fill(eachrow, -1); 
        int n=3,lasttask=3;
        System.out.println(calc(n-1,lasttask,arr,dp));      
    }    
}
