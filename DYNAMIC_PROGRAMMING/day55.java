import java.util.Arrays;

public class dp31_ShortestSuperSeq {
 public static int func(int ind1,int ind2,char[] str1,char[]str2,int[][] dp)
{
    if(ind1==0||ind2==0)
    return dp[ind1][ind2]=0;
    if(dp[ind1][ind2]!=-1)
    return dp[ind1][ind2];
    if(str1[ind1-1]==str2[ind2-1])   //"-1" is due to shifting of indexes.
    dp[ind1][ind2]=1+func(ind1-1, ind2-1, str1, str2, dp);
    else
    dp[ind1][ind2]=Math.max(func(ind1-1, ind2, str1, str2, dp),func(ind1, ind2-1, str1, str2, dp));
    return dp[ind1][ind2];
}
    public static void main(String[] args) {
        String string1="brute"; 
        String string2="groot";
        char[] str1=string1.toCharArray();
        char[] str2=string2.toCharArray();
        int ind1=str1.length;
        int ind2=str2.length;
        int[][] dp=new int[str1.length+1][str2.length+1];
        for(int[] each:dp)
        Arrays.fill(each,-1);

        int lcs=func(ind1,ind2,str1,str2,dp);  // storing the length of lcs.
        int i=ind1;  //for while loop below from the end of the dp array.
        int j=ind2;
    String str="";
    while(i>0 && j>0){  //see table in note
        if(string1.charAt(i-1) == string2.charAt(j-1)){  //if characters matches print and go diagonal...
           str+=string1.charAt(i-1);   //print (i th element in str1) or (j th element in str2)
            i--;
            j--;
        }
        else if(dp[i-1][j]>dp[i][j-1]){             
            str+=string1.charAt(i-1);    //print char at i th position in str1(so we are using i-1) 
            i--;                      //if element which is top has maximum value go upwards
        }
        else {
            str+=string2.charAt(j-1);
            j--;           //else left element has the maximum value so go leftwards
        } 
    }
    while(i>0){                             // print until characters exhaust in str1 -- go till i=1 in dp array to exhaust str1.        
        str+=string1.charAt(i-1);
            i--;
    }
    while (j>0) {
        str+=string2.charAt(j-1);           // print until characters exhaust in str2 -- go till j=1 in dp array to exhaust str2. 
            j--;
    }
    StringBuilder lcsstring=new StringBuilder(str);
    System.out.println("Shortest SuperSeq="+lcsstring.reverse());   // reverse and print
    }
    
}
