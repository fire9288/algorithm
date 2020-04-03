package algorithm;




public class Sparsearray {
    public static void main(String[] args) {


        //构建二维数组并输出
        int Myarry[][] = new int [11][11];
        Myarry[1][2] = 3;
        Myarry[2][3] = 7;

        int sum  = 0;//统计数组中有多少个不为0的数
        for(int a[]:Myarry){
            for(int b:a){
                if (b!=0)sum++;
                System.out.printf("%d\t",b);

            }
            System.out.println();
        }

        System.out.println("-----------");
        //构建稀疏数组
        int sparse[][] = new int[sum+1][3];
        sparse[0][0] = Myarry.length;
        sparse[0][1] = Myarry.length;
        sparse[0][2] = sum;

        int count=1; //用于记录稀疏数组的行数

        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){

                if(Myarry[i][j]!=0)
                {
                   sparse[count][0]=i;
                   sparse[count][1]=j;
                   sparse[count][2]=Myarry[i][j];
                    count++;
                }

            }
        }


        //遍历稀疏数组
        for(int a[]:sparse){
            for(int b:a){
                System.out.printf("%d\t",b);

            }
            System.out.println();
        }
        System.out.println("----------");
        //稀疏数组转回二维数组

        int Tarray[][] = new int[sparse[0][0]][sparse[0][1]];

        for(int i=1;i<sparse.length;i++){

            Tarray[sparse[i][0]][sparse[i][1]] = sparse[i][2];

        }



        for(int a[]:Tarray){
            for(int b:a){
                System.out.printf("%d\t",b);

            }
            System.out.println();
        }

    }
}
