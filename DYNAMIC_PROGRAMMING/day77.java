import java.util.ArrayList;
import java.util.Arrays;

public class dp42_47_print_count_lis {
    static void longestIncreasingSubsequence(int arr[], int n){
    int[] dp=new int[n];
    Arrays.fill(dp,1);
    int[] hash=new int[n];
    Arrays.fill(hash,1);
    int[] ct=new int[n];
    Arrays.fill(ct,1);
    for(int i=0; i<=n-1; i++){
        hash[i] = i; // initializing with current index
        for(int prev_index = 0; prev_index <=i-1; prev_index ++){       
            if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                dp[i] = 1 + dp[prev_index];
                hash[i] = prev_index;
                ct[i]=ct[prev_index];   //inheriting--if the perv LIS size=2 which is formed by 5 ways then adding the current element only increses the length of LIS by 1 and the count=5(ways) of the LIS remains the same
            }
            else if(arr[prev_index]<arr[i] && 1 + dp[prev_index] == dp[i]){
                ct[i]=ct[i]+ct[prev_index];   //if same length found addup both values.
            }
        }
    }
    int ans = -1;
    int lastIndex =-1;
    for(int i=0; i<=n-1; i++){
        if(dp[i]> ans){
            ans = dp[i];
            lastIndex = i;    //getting the index which holds the maximum dp value.
        }
    }
    int cnt =0;
    for(int i=0; i<=n-1; i++){
       if(dp[i]==ans) 
       cnt+=ct[i];             // add up add values in ct array which corresponds to maximum size of LIS
    }
    System.out.println("NO. OF LIS SEQUENCES="+cnt);
    ArrayList<Integer> temp=new ArrayList<>();
    temp.add(arr[lastIndex]);
    while(hash[lastIndex] != lastIndex){ // when 1st elememt reches the hash[index]=indexvalue so fails
        lastIndex = hash[lastIndex];  //NOTE:ORDER OF EXECUTION MUST.
        temp.add(arr[lastIndex]);    
    }
    // reverse the array 
    System.out.print("The subsequence elements are ");
    for(int i=temp.size()-1; i>=0; i--){
        System.out.print(temp.get(i)+" ");
    }   
}

public static void main(String args[]) {
	int arr[] = {1,5,4,3,2,6,7,2};//{10,9,2,5,3,7,101,18};
	int n = arr.length;
	longestIncreasingSubsequence(arr,n);
	
}
}
