public class dp52_maketrue {
//Given an expression, A, with operands and operators (OR, AND, XOR), in how many ways can you evaluate the expression to be true, by grouping it in different ways?
    static final int MOD = 1000000007;
    static long evaluateExpressionWays(String exp, int i, int j, int isTrue, Long[][][] dp) {
        // Base case 1: When the start index is greater than the end index, no ways to evaluate.
        if (i > j) {
            return 0;
        }
        // Base case 2: When the start and end indices are the same.
        if (i == j) {
            if (isTrue == 1) {
                return exp.charAt(i) == 'T' ? 1 : 0;  //return 1 when istrue==1 && char='T'
            } else {
                return exp.charAt(i) == 'F' ? 1 : 0;  //return 1 when istrue==0(we are expexting false count) && char=="F"
            }
        }
        if (dp[i][j][isTrue] != null) {    //NOTE
            return dp[i][j][isTrue];
        }
        long ways = 0;  //Note
        for (int ind = i + 1; ind <= j - 1; ind += 2) {   //operators start from 1st index to n-2th index(see note)
            long lT = evaluateExpressionWays(exp, i, ind - 1, 1, dp);
            long lF = evaluateExpressionWays(exp, i, ind - 1, 0, dp); //NOTE istrue==0(means we are expexted to count falses)
            long rT = evaluateExpressionWays(exp, ind + 1, j, 1, dp);
            long rF = evaluateExpressionWays(exp, ind + 1, j, 0, dp);
            char operator = exp.charAt(ind);
            if (operator == '&') {
                if (isTrue == 1) {
                    ways = (ways + (lT * rT) % MOD) % MOD; 
                } else {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lF * rF) % MOD) % MOD;
                }
            } else if (operator == '|') {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD + (lT * rT) % MOD) % MOD;  
                } else {
                    ways = (ways + (lF * rF) % MOD) % MOD;
                }
            } else {
                if (isTrue == 1) {
                    ways = (ways + (lF * rT) % MOD + (lT * rF) % MOD) % MOD;  
                } else {
                    ways = (ways + (lF * rF) % MOD + (lT * rT) % MOD) % MOD;
                }
            }
        } 
        return dp[i][j][isTrue] = ways;
    }
    public static void main(String[] args) {
        String exp = "F|T^F";
        int n = exp.length();
        Long[][][] dp = new Long[n][n][2]; // dp[i][j][k] stores the number of ways to evaluate the subexpression from index i to j with the result k (0 or 1).
        System.out.println("The total number of ways: " + evaluateExpressionWays(exp, 0, n - 1, 1, dp));
    }
}

