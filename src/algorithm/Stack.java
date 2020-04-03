package algorithm;

/**
 *
 *栈的实现
 *
 * 以及
 *
 * 简单计算器的实现
 */
public class Stack {

    public static void main(String[] args) {

        Mystack mystack = new Mystack(10);



    }

    static class Mystack{

        int MAX_SIZE;
        int top=-1;//栈顶
        int stack[];

        public Mystack(int max){

            this.stack = new int[max];
            MAX_SIZE = max;
        }

        public boolean isEmpty(){

           return  top==-1?true:false;
        }

        public boolean isFull(){
            return top==MAX_SIZE-1?true:false;
        }

        public void add(int x){
            if(isFull())throw new RuntimeException("栈已经满了");

            top++;
            stack[top]=x;
        }

        public int pop(){

            if(isEmpty())throw  new RuntimeException("emptt");

            int temp = stack[top];
            top--;
            return temp;
        }

        public void look(){
            for(int i=top;i>=0;i--){
                System.out.print(stack[i]+" ");
            }
        }



    }
}
