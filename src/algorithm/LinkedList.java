package algorithm;

import java.util.Stack;

public class LinkedList {
    public static void main(String[] args) {


        TheList theList = new TheList();
        theList.add(new Node(2,"林冲","豹子头"));
        theList.add(new Node(3,"卢俊义","玉麒麟"));
        theList.add(new Node(4,"吴用","智多星"));
        theList.add(new Node(6,"公孙胜","入云龙"));

//        theList.AddByOrder(new Node(5,"hu","aa"));
//
//        theList.Delete(5);
//        theList.Delete(6);

       theList.Look();

        System.out.println("----------------------");

//        theList.reverse();
////        theList.Look();

        theList.reversePrint();


    }


    static class TheList{

        Node Head = new Node(1,"","");

        public void add(Node node){

            Node temp = Head;
          while(true){

              if(temp.next==null)break;

              temp = temp.next;
          }
          temp.next=node;
        }

        public void Look(){
            if(Head.next==null){
                System.out.println("链表为空");
                return;
            }
            Node temp = Head.next;
            while(true){

                if(temp==null)break;
                System.out.println(temp.id+" "+temp.name+" "+temp.nickname);
                temp = temp.next;
            }
        }
        //修改某结点信息的代码略 因为类似

        public void AddByOrder(Node node){

            Node temp = Head;

            while(true){
                if(temp.next==null){
                    temp.next = node;
                    break;
                }
                if(temp.next.id>node.id){
                    node.next = temp.next;  //注意不要写反了
                    temp.next = node;


                    break;
                }
                if(temp.next.id==node.id){
                    System.out.println("已存在");
                    break;
                }
                temp = temp.next; //注意后移 有时候注意其他逻辑 忘记了最重要的指针后移
            }


        }

        public void Delete(int id){
            Node temp = Head;
            Boolean flag = false;
            if(temp.next == null){
                System.out.println("it's null");
            }
            while(true){

                if(temp.next.id==id){
                    temp.next = temp.next.next;
                    flag = true;
                    break;
                }
                temp = temp.next;
            }
            if(!flag){
                System.out.println("没有这个结点");
            }

        }

        /**
         *
         * 得到链表中倒数第n个值
         *
         * 思路：遍历链表 得到总数sum
         * 用sum - n 就得到正序的sum-n个节点就是想要的
         * 再次查找即可
         */
        public Node GetLast(int n){

            Node temp = Head;
            Node atemp = Head;
            int count =0;
            int location;
            if(temp.next==null){
                System.out.println("it's null");
            }
            while(true){
                if(temp.next==null){
                    break;
                }
                count++;
                temp= temp.next;

            }
            location = count-n+1;

            if(location<0||location>count){

                throw new RuntimeException("越界");
            }
            while(location!=0){
                atemp = atemp.next;
                location--;

            }
            return atemp;

        }

        /**
         * 反转单链表
         * 思路：
         * 定义新节点reversenode
         * 将原来链表中的节点一个个摘下 都放到revesenode的最前端
         * 最后让head.next=reversenode.next 就实现了反转
         *
         * 其中要注意 在操作过程中
         * 要保留temp.next的值 在进行摘下
         * 因为摘下后temp.next不再是原来的temp.next
         *
         */
        public void reverse(){

            if(Head.next==null||Head.next.next==null){
                System.out.println("无需反转");
                return;
            }

            Node reverseNode = new Node(1,"","");
            Node temp = Head.next;
            Node curr = null;
            while(temp!=null){

                curr = temp.next; //这里是重点 需要保留temp的下一个节点 因为后面的操作将temp.next改变了
                temp.next=reverseNode.next;
                reverseNode.next = temp;
                temp= curr;



            }
            Head.next = reverseNode.next;

        }

        /**
         * 逆序遍历单链表
         * 方法1：上面方法 反转链表再打印即可 但是要求是逆序打印并没有要求反转
         * 方法2：使用栈的先进后出原理 实现逆序
         */

        public void reversePrint(){

            Node temp = Head.next;

            if(temp==null){
                System.out.println("无需逆序打印");
                return;
            }

            Stack<Node> stack = new Stack<>();

            while(temp!=null){
                stack.add(temp);
                temp = temp.next;
            }

            while(stack.size()>0){
                System.out.println(stack.pop().id);
            }


        }
    }

    static class Node {

        int id;
        String name;
        String nickname;
        Node next;

        public Node(int id,String name,String nickname){

            this.id = id;
            this.name =name;
            this.nickname = nickname;

        }



    }


}
