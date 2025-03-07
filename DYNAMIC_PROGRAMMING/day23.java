import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dp14_ss_with_sum_k {
    public static boolean subsetsum(int ind, int target, int[] arr, int[][] dp) {
        if (target == 0) // if the target is 0 we achieved the sum k
            return true;

        if (ind == 0)
            return arr[0] == target; // if index reached 0 then the value at index 0 must be equal to the balance target (returns true) else target is not achieved and false is returned.

        if (dp[ind][target] != -1)
            return dp[ind][target] == 1; // if 1 is present in dp array then true is returned.

        boolean notpick = subsetsum(ind - 1, target, arr, dp);
        boolean pick = false; 
        if (arr[ind] <= target)
            pick = subsetsum(ind - 1, target - arr[ind], arr, dp); // if we pick the element we must subtract it from target.
        dp[ind][target] = pick || notpick ? 1 : 0; // store 1 if true else store 0.
        return pick || notpick; // return true if any one selection(pick,notpick) is true
    }

    public static void findSubsets(int ind, int target, int[] arr, int[][] dp, List<Integer> currentSubset, List<List<Integer>> allSubsets) {
        if (target == 0) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        if (ind == 0) {
            if (arr[0] == target) {
                currentSubset.add(arr[0]);
                findSubsets(ind - 1, target-arr[0], arr, dp, currentSubset, allSubsets);
                currentSubset.remove(currentSubset.size() - 1);
            }
            return;
        }
        if (dp[ind - 1][target] !=0) {
            findSubsets(ind - 1, target, arr, dp, currentSubset, allSubsets);
        }

        if (arr[ind] <= target && dp[ind - 1][target - arr[ind]] !=0) {
            currentSubset.add(arr[ind]);
            findSubsets(ind - 1, target - arr[ind], arr, dp, currentSubset, allSubsets);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;
        int[][] dp = new int[n][k + 1];
        for (int[] each : dp)
            Arrays.fill(each, -1);

        boolean result = subsetsum(n - 1, k, arr, dp);
        if (result) {
            System.out.println("Subset found");
            List<List<Integer>> allSubsets = new ArrayList<>();
            findSubsets(n - 1, k, arr, dp, new ArrayList<>(), allSubsets);
            System.out.println("The subsets are: ");
            for (List<Integer> subset : allSubsets) {
                System.out.println(subset);
            }
        } else {
            System.out.println("Subset not found.");
        }
    }
}
