package algorithm;


/**
 *
 *
 * 环形队列
 *
 */
public class Cqueue {

    public static void main(String[] args) {

        Myqueue myqueue = new Myqueue(10);

        myqueue.AddElement(3);
        myqueue.AddElement(4);
        myqueue.AddElement(1);
        System.out.println("出队: "+myqueue.GetElement());
        System.out.println("-----------以下为遍历队列------------");
        myqueue.Getall();
    }

    static class Myqueue{

        int MaxSize;
        int front;
        int tail;
        int tqueue[];

        public Myqueue(int MaxSize){

            this.MaxSize = MaxSize;
            tqueue = new int [MaxSize];
        }

        public boolean isEmpty(){

            return front==tail;
        }

        public boolean isFull(){

            return (tail+1)%MaxSize==front;
        }

        public void AddElement(int n){

            if(isFull()){throw new RuntimeException("Queue if full");}


            tqueue[tail] = n;

            tail = (tail+1)%MaxSize;
        }

        public int GetElement(){
            if(isEmpty()){throw new RuntimeException("Queue is Empty");}



            int temp =  tqueue[front];
            front = (front+1)%MaxSize;

            return  temp;

        }

        public void Getall(){

            System.out.println("有效数据个数还有： ");
            for(int a=front;a<front+size();a++){
                System.out.println(tqueue[a]);

            }
        }

        public int size(){
            return (tail+MaxSize-front)%MaxSize;
        }

    }
}
