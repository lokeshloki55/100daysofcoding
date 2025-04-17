import java.util.Arrays;

public class dp33_editDistance {
     static int editDistanceUtil(String S1, String S2, int i, int j, int[][] dp) {
        // Base cases
        if (i <= 0)    //i==0 means str1 exhausted and we are at -1 index at str1.
            return j ;   // str1 exhausted but still we have j+1 characters in str2 
        if (j <= 0)
            return i ;    // str2 exhausted but still we have i+1 characters in str1 

        // If the result is already computed, return it
        if (dp[i][j] != -1)
            return dp[i][j];

        // If the characters at the current positions match, no edit is needed so add 0
        if (S1.charAt(i-1) == S2.charAt(j-1))   //due to shifting we put i-1 & j-1
            return dp[i][j] = editDistanceUtil(S1, S2, i - 1, j - 1, dp);

        // Minimum of three choices:
        // 1. Replace the character in S1 with the character in S2.
        // 2. Delete the character in S1.
        // 3. Insert the character from S2 into S1.
        else
            return dp[i][j] = 1 + Math.min(editDistanceUtil(S1, S2, i - 1, j - 1, dp),   //1 is added for every action performed
                    Math.min(editDistanceUtil(S1, S2, i - 1, j, dp), editDistanceUtil(S1, S2, i, j - 1, dp)));
    }
    public static void main(String args[]) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1]; //extra spaces for shifting of indexes 
        for (int row[] : dp)
            Arrays.fill(row, -1);
        System.out.println("The minimum number of operations required is: " +editDistanceUtil(s1,s2, n , m , dp));
    }
}
