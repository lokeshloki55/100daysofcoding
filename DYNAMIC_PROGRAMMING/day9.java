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
            int maxi_curr=calc(day-1, curr_task, arr, dp)+arr[day][curr_task];//taking every element in current day and adding it to previous day recursion and passing lastdaytask=curre_task in current iteration because curr_task is the task performed in the current day
            maxi=Math.max(maxi,maxi_curr);//oru current day (nth) activity eduthu adha previous day la endha activity kooda add pana maximum varthu nu pakrom and similarly antha day oda ella task kum check panrom side by side maximum value override agite varum.
        }
    }
     return dp[day][lasttask]=maxi;
}
    public static void main(String[] args) {
        int [][] arr={{10,40,70},{20,50,80},{30,60,90}};
        int [][] dp=new int[3][4];//3 is number of days and 4 is number of activities that can be performed in a day(3(given activities)+1(no restrictions,used in nth day which is first used in recurrance(see note))
        for(int[] eachrow:dp)
        Arrays.fill(eachrow, -1); 
        int n=3,lasttask=3;//initially last task is taken as 3 because you can take any task without any restrictions initially.
        System.out.println(calc(n-1,lasttask,arr,dp));      
    }    
}
