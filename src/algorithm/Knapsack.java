package algorithm;

/**
 *
 *
 * 0-1背包问题
 *
 * 拿在手里的物品重量大于当前背包重量 就用上一个的最佳结果
 * 拿在手里的额物品小于等于当前背包重量 就权衡一下 是当前物品重量加上背包重量减去当前物品重量的价值总和大 还是 上一个的最佳结果大 选最好的
 *
 * 每一次的结果都要依靠之前的结果  符合动态规划
 */
public class Knapsack {

    public static void main(String[] args) {

        int w[] = {1, 4, 3};//物品的价值对应重量
        int val[] = {1500, 3000, 2000};//物品价值

        int m = 4;//背包容量
        int n = val.length;//物品数量

        int path[][] = new int[n+1][m+1];//记录什么时候更新了最佳值
        int v[][] = new int[n+1][m+1]; //v[i][j]为在前i个物品中能够放入重量为j的背包的最大价值

        for (int i = 1; i < v.length; i++) {

            for (int j = 1; j < v[i].length; j++) {

                if (w[i-1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    if (v[i - 1][j] < val[i-1] + v[i-1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        for (int k = 0; k < v.length; k++) {
            for (int y = 0; y < v[k].length; y++) {
                System.out.print(v[k][y]+" ");
            }
            System.out.println();
        }
        System.out.println("-----");
        for (int k = 0; k < v.length; k++) {
            for (int y = 0; y < v[k].length; y++) {
                System.out.print(path[k][y]+" ");
            }
            System.out.println();
        }

        int ii = path.length-1;
        int jj = path[0].length-1;

        while(ii>0&&jj>0){

            if(path[ii][jj]==1) {
                System.out.println("拿出第" + ii + "个物品放入背包");
                jj -= w[ii-1];
            }
            ii--;
        }
    }
}
