import java.util.Arrays;

public class dp30_min_insertions_str1equalstr2 {
public static int func(int ind1,int ind2,char[] str1,char[]str2,int[][] dp)
{
    if(ind1==0||ind2==0)
    return dp[ind1][ind2]=0;
    if(dp[ind1][ind2]!=-1)
    return dp[ind1][ind2];
    if(str1[ind1-1]==str2[ind2-1])   
    dp[ind1][ind2]=1+func(ind1-1, ind2-1, str1, str2, dp);
    else
    dp[ind1][ind2]=Math.max(func(ind1-1, ind2, str1, str2, dp),func(ind1, ind2-1, str1, str2, dp));  
    return dp[ind1][ind2];
}
    public static void main(String[] args) {
        String string1="abcd"; //ans:3 deletions-2(b,d) & insertions-1(n)
        String string2="anc";
        char[] str1=string1.toCharArray();
        char[] str2=string2.toCharArray();
        int ind1=str1.length;
        int ind2=str2.length;
        int[][] dp=new int[ind1+1][ind2+1]; 
        for(int[] each:dp)
        Arrays.fill(each,-1);
        int lcs=func(ind1,ind2,str1,str2,dp);
        int ans=(ind1-lcs)+(ind2-lcs);   
        System.out.println("Minimum insertions/deletions to be made in str1 to make str1=str2 is: "+ans);
    }
    
}
