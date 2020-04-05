package algorithm;


public class Test {


    public static void main(String[] args) {


        String str = "42";

        myAtoi(str);


    }

    public static  int myAtoi(String str){


        //处理空格
        for(int i=0;i<str.length();i++){

            if(str.charAt(i)==' '){
                str = str.substring(i+1,str.length());
                i--;
            }
            else break;
        }

        //处理空格后如果第一个字符不是 数字或者正负号 return 0


         if(str.charAt(0)<48&&str.charAt(0)!='-'&&str.charAt(0)!='+')return 0;
        else if(str.charAt(0)>57)return 0;

        //如果是纯整数


        if(str.charAt(0)!='-'){
            int count =0;
            int a[]=new int[str.length()];

            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>=48||str.charAt(i)<=57){
                        a[count]=str.charAt(i)-48;
                        count++;
                }
                else break;
            }
            int j=0;
            for (int i : a) {
                j*=10;
                j+=i;

            }

            if(j>Integer.MAX_VALUE) System.out.println(Integer.MAX_VALUE);
            else
            System.out.println(j);
        }else{

            int count =0;
            int a[]=new int[str.length()-1];

            for(int i=1;i<str.length();i++){
                if(str.charAt(i)>=48||str.charAt(i)<=57){
                    a[count]=str.charAt(i)-48;
                    count++;
                }
                else break;
            }
            int j=0;
            for (int i : a) {
                j*=10;
                j+=i;

            }

            if(-j<Integer.MIN_VALUE) System.out.println(Integer.MIN_VALUE);
            else
                System.out.println(-j);




        }





        return 0;
    }
}
