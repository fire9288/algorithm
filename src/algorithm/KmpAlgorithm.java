package algorithm;

/**
 * kmp算法核心
 *
 * 在于找到 next[]数组的值
 * next:由子串通过前后缀匹配得到
 *
 * resolvekmp和Getnext的核心都在
 * 当str1.charat[]和str2.charat[]不相等的时候的代码
 *
 *
 *
 */
public class KmpAlgorithm {

    public static void main(String[] args) {

        String str1 = "abcdabd"; //子串
        String str2 = "bbc abcdab cbabcdabdabde";//主串
        int next[]=GetNext(str1);

        System.out.println(ResolveKmp(str1,str2,next));

    }

    public static int ResolveKmp(String str1,String str2,int next[]){

        for(int i=0,j=0;i<str2.length();i++){


            while(j>0&&str1.charAt(j)!=str2.charAt(i)){
                j = next[j-1];
            }

            if(str2.charAt(i)==str1.charAt(j)){
                j++;
            }
            if(j==str1.length()){
                return i-j+1;
            }
        }
        return -1;

    }



    public static int[] GetNext(String str1){

        int next[]=new int[str1.length()];

        next[0]=0;

        for(int i=1,j=0;i<str1.length();i++){


            while(j>0&&str1.charAt(i)!=str1.charAt(j)){

                j = next[j-1];
            }


            if(str1.charAt(i)==str1.charAt(j)){

                j++;
            }

            next[i]=j;


        }

        return next;
    }
}
