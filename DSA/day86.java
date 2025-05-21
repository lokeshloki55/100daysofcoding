class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum+nums[i]>=0){
                sum+=nums[i];
            }
            else{
                sum=0;
            }
            if(maxsum<sum){
                maxsum=sum;
            }
        }
        int max=Integer.MIN_VALUE;
        if(maxsum==0){
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){
                    max=nums[i];
                }
            }
            maxsum=max;
        }
        return maxsum;
    }
}
