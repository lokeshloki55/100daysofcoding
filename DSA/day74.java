class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> dlis=new ArrayList<>();
        List<Integer>arr=new ArrayList<>();
        for(int i=0;i<candidates.length;i++){
            arr.add(candidates[i]);
        }
        func(0,arr,new ArrayList<>(),dlis,target);
        return dlis;
    }
     public void func(int ind,List<Integer>arr,List<Integer>slis,List<List<Integer>> dlis,int target){
        int sum = slis.stream().mapToInt(Integer::intValue).sum();
        if (sum == target) {
            dlis.add(new ArrayList<>(slis));
            return;
        }
        // If the current combination exceeds the target, stop processing this path
        if (sum > target) {
            return;
        }

        // Iterate over the candidates starting from the current index
        for (int i = ind; i < arr.size(); i++) {
            slis.add(arr.get(i)); // Add the current element
            func(i, arr, slis, dlis, target); // Recur with the same element to allow duplicates
            slis.remove(slis.size() - 1); // Backtrack
        }
    }
}
