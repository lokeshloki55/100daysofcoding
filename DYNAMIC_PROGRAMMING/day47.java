import java.util.Arrays;

public class dp27_longestsubstring {
     public static void main(String[] args) {
        String string1="abcde";
        String string2="bdegk";
        char[] str1=string1.toCharArray();
        char[] str2=string2.toCharArray();
        int ind1=str1.length;
        int ind2=str2.length;
        int[][] dp=new int[ind1+1][ind2+1]; 
        for(int[] each:dp)
        Arrays.fill(each,-1);
    
        int i,j;
        for(i=0;i<=ind1;i++)
        dp[i][0]=0;
        for(i=0;i<=ind2;i++)
        dp[0][i]=0;
        for(i=1;i<=ind1;i++)
        {
            for(j=1;j<=ind2;j++){
                if(str1[i-1]==str2[j-1])   
                  dp[i][j]=1+dp[i-1][j-1];
                 else
                  dp[i][j]=0; 
            }
        }
        
        int maxi=0;
        for(int[] each:dp) { 
        maxi=Math.max(Arrays.stream(each).max().getAsInt(),maxi);
       // System.out.println(Arrays.toString(each));
    }
        System.out.println("length of longest common SUBSTRING is "+maxi);
    }
}
