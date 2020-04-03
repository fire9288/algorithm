package algorithm;

/**
 * 约瑟夫问题
 *1.构造环形链表
 * 2.
 *
 * 遍历链表千万不要忘记指针往后移动
 */
public class Josephu {

    public static void main(String[] args) {

        CircleSingleLinkedList c = new CircleSingleLinkedList();
        c.Add(5);

//        c.Look();


        c.ResolveJosephu(1,2,5);
    }

    //构造环形链表
    static class CircleSingleLinkedList{

        Node first = null;//第一个节点

        public void Add(int num) {

            Node temp = null;
            for(int i=1;i<=num;i++){

                Node node = new Node(i);

                if(i==1){
                    first = node;
                    first.next = first;
                    temp = first;
                }
                else {
                    temp.next = node;
                    node.next = first;
                    temp = node;
                }

            }


        }

        public void Look(){
            Node temp = first;
            while(true){

                if(temp.next==first){
                    System.out.println(temp.id);
                    break;
                }
                System.out.println(temp.id);
                temp = temp.next;
            }
        }

        /**
         * 约瑟夫问题解法
         * @param startNo 开始小孩的编号
         * @param m   每次移动几次
         * @param n    总人数
         */
        public void ResolveJosephu(int startNo,int m,int n){

            Node helper = first;

            //先让helper指向链表的最后一个人
            while(true){
                if(helper.next==first){
                    break;
                }
                helper = helper.next;
            }

            //开始按照给定的startNo 让first指向第一个开始游戏的小孩
            for(int i=0;i<startNo-1;i++){
                first = first.next;
                helper = helper.next;
            }

            //开始游戏
            while(true){

                if(helper==first){
                    System.out.println("游戏结束");
                    break;
                }
                for(int j=0;j<m-1;j++){
                    helper = helper.next;
                    first = first.next;
                }
                System.out.println(first.id+"号小号出局");
                first = first.next;
                helper.next = first;


            }
            System.out.println("最后只剩下了"+first.id+"号小孩");
        }

    }





    static class Node {

        int id;
        Node next;

        public Node(int id){

            this.id = id;


        }



    }

}
