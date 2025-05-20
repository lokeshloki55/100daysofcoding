import java.util.Stack;
//Given a -r*c matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
public class dp55_largest_rectangal {
    public static int largerec(int[] arr){
        int n = arr.length;
        Stack < Integer > st = new Stack < > ();
        int leftSmall[] = new int[n];      //NOTE:used to store indexes.
        int rightSmall[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {   //pop until all bigger elements are gone
                st.pop();
            }

            if (st.isEmpty()) 
            leftSmall[i] = 0; //if no small element is found before 0th index is the leftmost endpoint
            else 
            leftSmall[i] = st.peek() + 1; //NOTE
            
            st.push(i);   //finally push the current element th index to stack.
        }

        // clear the stack to be re-used
        while (!st.isEmpty()) 
        st.pop();

        for (int i = n - 1; i >= 0; i--) {          //loop from last
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) 
            rightSmall[i] = n - 1;        //if stack empty(means no right low is found) last index is the right mostendpoint
            else 
            rightSmall[i] = st.peek() - 1;  //NOTE

            st.push(i);
        }

        int maxA = 0;
        for (int i = 0; i < n; i++) {
            maxA = Math.max(maxA, arr[i] * (rightSmall[i] - leftSmall[i] + 1));      //formula(right-left+1)*height   here +1 is added because of 0 based indexing
        }
        return maxA;
    }
    public static void main(String[] args) {
       int arr[][]= { {1, 0, 1, 0, 0}, {1, 0, 1, 1, 1},{1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
       int height[]=arr[0];
       int max=largerec(height);    //storing the max rectangle area that can be formed with 1st row
       for(int i=1;i<arr.length;i++){
        int curh[]=arr[i];
        for(int j=0;j<curh.length;j++){
            if(curh[j]==1)
            curh[j]+=height[j];            //adding the values if 1 is present in current element elseif 0 is presnt leave as it is.
        }
        int currmax=largerec(curh);       //getting max rectangle area with current row th histogram.
        if(currmax>max)
        max=currmax;
       height=curh;                        //updating the height array with current value for further use.
       }
       System.out.println(max);
    }
}
