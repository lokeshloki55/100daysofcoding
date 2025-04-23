public class dp35 {
    public static void main(String[] args) {
           
            int arr[]={7,1,5,3,6,4}; //ans=5(buy@1 sell@6)
            int n=arr.length;
            int mini=arr[0];
            int maxprofit=0;
            for(int i=0;i<n;i++)
            {   int cur_profit=arr[i]-mini;      //to find the max profit and if we are at i th day we have to find minimum value from 1st day to (i-1)th day  
                maxprofit=Math.max(maxprofit,cur_profit);
                mini=Math.min(mini,arr[i]);   //it maintains the minimum value from 0 to i th index.
            }
            System.out.println("Max profit:"+maxprofit);
}  
}
