class Solution {
    public int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[][]visited=new int[n][n];
        Queue<Integer>q=new LinkedList<>();
        q.add(1);
        visited[n-1][0]=1;   // we start at left bottom
        int steps=0;  
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){  //must
            int pos=q.poll();
            if(pos==n*n)  //if we reached target
            return steps;

            for(int i=1;i<=6;i++){  //see all possibilities
                if(pos+i>n*n)   //if exceeds board skip
                continue;

                int[] coordinates=findcoordinates(pos+i,n);  //find x,y in board
                int row=coordinates[0];
                int col=coordinates[1];

                if(visited[row][col]==1)   //if already visited skip
                continue;

                visited[row][col]=1;

                if(board[row][col]==-1)   //no ladder or snake
                q.add(pos+i);     
                else
                q.add(board[row][col]);
            }}
            steps++;
        }
        return -1;
    }
    public int[] findcoordinates(int pos,int n){
        int r=n-(pos-1)/n-1;
        int c=(pos-1)%n;
        if(r%2==n%2)
        return new int[]{r,n-1-c};
        return new int[]{r,c};
    }
}
