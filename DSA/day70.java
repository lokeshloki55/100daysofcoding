class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> dlis=new ArrayList<>();
        List<Integer>arr=new ArrayList<>();
        for(int i=1;i<=n;i++){
            arr.add(i);
        }
        func(0,arr,new ArrayList<>(),dlis,k);
        return dlis;
    }

    public void func(int ind,List<Integer>arr,List<Integer>slis,List<List<Integer>> dlis,int k){
        if(ind==arr.size()){
         if(slis.size()==k){
           dlis.add(new ArrayList<>(slis));
           return;
        }
        else
        return;
        }
        if(slis.size()==k){
           dlis.add(new ArrayList<>(slis));
           return;
        }
        slis.add(arr.get(ind));
        func(ind+1,arr,slis,dlis,k);
        slis.remove(Integer.valueOf(arr.get(ind)));
        func(ind+1,arr,slis,dlis,k);
    }
}
