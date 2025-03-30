import java.util.Arrays;

public class dp25_longestcommonsequence {
public static int func(int ind1,int ind2,char[] str1,char[]str2,int[][] dp)
{
    if(ind1==0||ind2==0)
    return dp[ind1][ind2]=0;   //NOTE (here 0th index means -1th index.In -1 th index there is no lcs )
    if(dp[ind1][ind2]!=-1)
    return dp[ind1][ind2];
    if(str1[ind1-1]==str2[ind2-1])   //compare two strings.-> (ind-1) is due to shifting.
    //here not as take,nottake here we use if else
    dp[ind1][ind2]=1+func(ind1-1, ind2-1, str1, str2, dp);// go previous in both strings(in dp table go diagonal)
    else
    dp[ind1][ind2]=Math.max(func(ind1-1, ind2, str1, str2, dp),func(ind1, ind2-1, str1, str2, dp));  //other ways to compare both strings if there is common sequence.
    return dp[ind1][ind2];
}

    public static void main(String[] args) {
        String string1="abcde"; //ans:3(bde)
        String string2="bdgek";
        char[] str1=string1.toCharArray();
        char[] str2=string2.toCharArray();
        int ind1=str1.length;
        int ind2=str2.length;
        int[][] dp=new int[ind1+1][ind2+1]; 
        for(int[] each:dp)
        Arrays.fill(each,-1);
        System.out.println("length of longest common SUBSEQUENCE is "+func(ind1,ind2,str1,str2,dp));  
    }
}
