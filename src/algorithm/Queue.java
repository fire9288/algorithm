package algorithm;


/**
 * 该队列为数组的简单队列实现方式
 *
 * 只能用一次 不能复用
 *
 * 如果复用要用到环形队列
 *
 */
public class Queue {

    public static void main(String[] args) {

        Myqueue myqueue = new Myqueue(10);

        myqueue.AddElement(3);
        myqueue.AddElement(4);
        myqueue.AddElement(1);
        myqueue.GetElement();
        System.out.println(  myqueue.isEmpty());
        myqueue.Getall();
    }

    static class Myqueue{

        int MaxSize;
        int front;
        int tail;
        int tqueue[];

        public Myqueue(int MaxSize){

            this.MaxSize = MaxSize;
            front = -1;
            tail = -1;
            tqueue = new int [MaxSize];
        }

        public boolean isEmpty(){

            return front==tail;
        }

        public boolean isFull(){

            return tail==MaxSize-1;
        }

        public void AddElement(int n){

            if(isFull()){throw new RuntimeException("Queue if full");}

            tail++;
            tqueue[tail] = n;
        }

        public int GetElement(){
            if(isEmpty()){throw new RuntimeException("Queue is Empty");}

            front++;
          return  tqueue[front];

        }

        public void Getall(){

            int count=0;
            for(int a:tqueue){
                System.out.println(tqueue[count]);
                count++;
            }
        }
    }
}
