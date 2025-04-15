import java.util.Arrays;

public class dp32_distinctSubsequences {
    static int countss(String s1, String s2, int ind1, int ind2, int[][] dp) {
        
        if (ind2 == 0)   // If we have exhausted s2, we found one valid subsequence of s2 in s1.(0 in dp array means -1 th index in string which means we have exhausted it )
            return 1;   //s2 is the target string.
       
        if (ind1 == 0)    // If we have exhausted s1 but not s2, there are no valid subsequences beacuse there is no more characters in s1 to compare with s2.
            return 0;

        if (dp[ind1][ind2] != -1)
            return dp[ind1][ind2];
        int ans;
        if (s1.charAt(ind1-1) == s2.charAt(ind2-1)) {    //"-1" is used because of shifting of indexes.
            int goBackBoth = countss(s1, s2, ind1 - 1, ind2 - 1, dp);   //move back in both strings
            int stay = countss(s1, s2, ind1 - 1, ind2, dp);     // find the another occurance of the matched char in s1 by moving back.
            ans= (goBackBoth + stay);      // Add both possibilites.
        } 
        else {
            // If the characters don't match, go back to prev character in s1 while staying in same char in s2 because it is still not matched.
            ans= countss(s1, s2, ind1 - 1, ind2, dp);
        }
        return dp[ind1][ind2]=ans;
    }
    
    public static void main(String args[]) {

        String s1 = "babgbag";
        String s2 = "bag";
        int ind1=s1.length()+1;   // extra space for shifting of indexes.
        int ind2=s2.length()+1;   // extra space for shifting of indexes.
        int dp[][] = new int[ind1][ind2];
        for (int rows[] : dp)
            Arrays.fill(rows, -1);
        System.out.println("The Count of Distinct Subsequences of s2 present in s1 is " +countss(s1, s2,ind1-1,ind2-1,dp));
    }
}
