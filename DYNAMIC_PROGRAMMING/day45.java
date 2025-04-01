import java.util.Arrays;

public class dp26_print_lcs {
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
        String string1="abcde";
        String string2="bdgek";
        char[] str1=string1.toCharArray();
        char[] str2=string2.toCharArray();
        int ind1=str1.length;
        int ind2=str2.length;
        int[][] dp=new int[str1.length+1][str2.length+1];
        for(int[] each:dp)
        Arrays.fill(each,-1);

        int lcs=func(ind1,ind2,str1,str2,dp);  // storing the length of lcs.
        int i=ind1;  //to start the while loop below from the end of the dp array.
        int j=ind2;
        String str="";
    
    while(i>0 && j>0){  //see table in note
        if(string1.charAt(i-1) == string2.charAt(j-1)){  //if characters matches print and go diagonal...
            str+=string1.charAt(i-1);  // add string2.charAt(j-1) to the str.
            i--;
            j--;
        }
        else if(dp[i-1][j]>dp[i][j-1]){  //if up index has greater value go upwards
            i--;
        }
        else j--; //else left index has the maximum value so go leftwards.
    }
    StringBuilder lcsstring=new StringBuilder(str);
    System.out.println("LCS="+lcsstring.reverse());  // print in reverse order.
    }
}
