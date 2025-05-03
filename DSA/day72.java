class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> dlis=new ArrayList<>();
        func(0,nums,dlis);
        return dlis;
    }
    public void func(int ind,int[]arr,List<List<Integer>>dlis){
        if(ind==arr.length){
            List<Integer>temp=new ArrayList<>();
            for(int i=0;i<arr.length;i++){
                temp.add(arr[i]);
            }
            dlis.add(temp);
            return;
        }
        for(int i=ind;i<arr.length;i++){
            swap(i,ind,arr);
            func(ind+1,arr,dlis);
            swap(i,ind,arr);
        }
        return;
    }

    public void swap(int i,int j,int[] arr){
         int temp=arr[i];
         arr[i]=arr[j];
         arr[j]=temp;
         return;
    }
}
