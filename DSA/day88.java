class Solution {
    public int maxSubarraySumCircular(int[] nums) {
         int totalSum = 0;
    int currMaxSum = 0;
    int currMinSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int minSum = Integer.MAX_VALUE;

    for (int a : nums) {
      totalSum += a;
      currMaxSum = Math.max(currMaxSum + a, a);//this is kadanes
      currMinSum = Math.min(currMinSum + a, a);
      maxSum = Math.max(maxSum, currMaxSum);
      minSum = Math.min(minSum, currMinSum);
    }

    return maxSum < 0 ? maxSum : Math.max(maxSum, totalSum - minSum);
    //if all elements are negative we ca return the smallest negative element which will be stored in maxsum(got using kadanes)
 //else totalsum-mininmumsubarraysum will the value which will the sum of remaining elements which is the maximmum subarray sum
  }
}
