package algorithm;

public class Maze {


    public static void main(String[] args) {
        int maze[][]=new int[8][7];
        for(int i=0;i<8;i++){
            maze[i][0]=1;
            maze[i][6]=1;

        }
        for(int i=0;i<7;i++){
            maze[0][i]=1;
            maze[7][i]=1;

        }

        maze[3][1]=1;
        maze[3][2]=1;


        find(maze,1,1);
        for (int[] ints : maze) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }

    /**
     *
     *
     * @param maze  迷宫矩阵
     * @param x     起始点x
     * @param y     起始点y
     *
     *  在maze中 0代表未走过 1代表墙 2代表走过的地方 3代表不可行
     *
     *  给定一个走路方式 先下后右 然后上 然后左
     */
    static boolean find(int maze[][],int x,int y){

       if(maze[6][5]==2)return true;

       if(maze[x][y]==0){
           maze[x][y]=2;
           if(find(maze,x+1,y))return true;
           if(find(maze,x,y+1))return true;
           if(find(maze,x-1,y))return true;
           if(find(maze,x,y-1))return true;
           maze[x][y]=3;
       }
       else{
           return false;
       }

       return true;



    }
}
