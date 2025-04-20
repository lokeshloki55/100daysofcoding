class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         int len=numCourses;
        int i;
        ArrayList<ArrayList<Integer>>arr=new ArrayList<>();  //adjacency list
        for(i=0;i<len;i++){
            arr.add(new ArrayList<>());
        }
        for(i=0;i<prerequisites.length;i++){      //see size***
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int[] indegree=new int[len];

        for(i=0;i<len;i++){
            ArrayList<Integer>temp=arr.get(i);
            for(int each:temp){      //in this problem all adjacent elements are indegree vectors
            indegree[each]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(i=0;i<len;i++){     //adding nodes with indegrree=0 to queue
            if(indegree[i]==0)
            q.add(i);
        }
        ArrayList<Integer>ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.peek();
            q.remove();
            ans.add(node);   //**//
            for(int each:arr.get(node)){
                indegree[each]--;   //while removing a node decrement one indegree value to all connected elements
                if(indegree[each]==0)
                q.add(each);
            }
        }
        Collections.reverse(ans);
       int[] topo=new int[ans.size()];
       Integer[] temp=ans.toArray(new Integer[0]);
       for(i=0;i<ans.size();i++){
        topo[i]=temp[i];
       }
        if(ans.size()==len)
        return topo;
        return new int[0];   //returning a empty array
    }
}
