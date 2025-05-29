class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i+=3){//jump three elemnets
            if(nums[i]!=nums[i-1])
            return nums[i-1];
        }
        return nums[nums.length-1];  //if not found anywhere the last element will be the culprit
    }
}
