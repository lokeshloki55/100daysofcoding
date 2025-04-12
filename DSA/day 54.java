class point{
    int x;
    int y;
    public point(int x,int y){
        this.x=x;
        this.y=y;
    }
}

class Solution {
   public void bfs(int i,int j,char[][] grid,int[][] visited){
    point p=new point(i,j);
    Queue<point> qq=new LinkedList<>();  
    qq.add(p);                                //ADD THE INTIAL STARTING POINT 
     visited[i][j] = 1;  // Mark the starting point as visited
    int m=grid.length,n=grid[0].length;
    while(!qq.isEmpty()){
                                             //DO BFS TRAVERSAL UNTIL QUEUE IS EMPTY
        i=qq.peek().x;
        j=qq.peek().y;
        qq.remove();

    if(i+1<m&&grid[i+1][j]=='1'&&visited[i+1][j]!=1){   // SEE IF TOP ELEMENT IS '1' AND NOT VISITED
        visited[i+1][j]=1;                              
        qq.add(new point(i+1,j));                     
    }
    if(j+1<n&&grid[i][j+1]=='1'&&visited[i][j+1]!=1){    //FOR RIGHT ELEMENT
        visited[i][j+1]=1;
        qq.add(new point(i,j+1));
    }
    if(i-1>=0&&grid[i-1][j]=='1'&&visited[i-1][j]!=1){
        visited[i-1][j]=1;
        qq.add(new point(i-1,j));
    }
    if(j-1>=0&&grid[i][j-1]=='1'&&visited[i][j-1]!=1){
        visited[i][j-1]=1;
        qq.add(new point(i,j-1));
    }
    }
    
   }
    public int numIslands(char[][] grid) { 
    
    int cnt=0,m=grid.length,n=grid[0].length,i,j;
    int[][] visited=new int[m][n];
    for(int[] each:visited){
        Arrays.fill(each,0);
    }

    for(i=0;i<m;i++){
        for(j=0;j<n;j++){
            if(grid[i][j]=='1'&&visited[i][j]!=1){               
                cnt++;
                bfs(i,j,grid,visited);                  //FOR EACH STARTING '1' WE HAVE TO DO BFS TRAVERSAL.
            }
        }
    }
    return cnt;            //RETURN THE NIUMBER OF STARTING POINT
    }
}
