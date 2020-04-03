package algorithm;

public class AVLTree {

    public static void main(String[] args) {

        int arr[]={4,3,6,5,7,8};
        MyAVLTree myTree = new MyAVLTree();


        for (int i : arr) {
            myTree.add(new Node(i));
        }

        myTree.in();

        System.out.println();
        System.out.println( myTree.getHeight());
        System.out.println(myTree.getLeftHeight());
        System.out.println(myTree.getRightHeight());

    }
    static class MyAVLTree{

        Node root;
        void pre(){root.preorder();}
        void in(){root.inorder();}
        void post(){root.postorder();}

        int getHeight(){
            return  root.getheight();
        }
        public void add(Node x){
            if(root==null)root=x;
            root.add(x);
        }
        int getLeftHeight(){
            return root.getLeftHeight();
        }
        int getRightHeight(){

            return root.getRightHeight();
        }

    }
    static class Node{

        Node left;
        Node right;
        int num;
        public Node(int n){
            this.num = n ;
        }

        int getheight(){

            return Math.max(this.left==null?0:this.left.getheight(),this.right==null?0:this.right.getheight())+1;
        }

        int getLeftHeight(){

            return this.left==null?0:this.left.getheight();

        }
        int getRightHeight(){

            return this.right==null?0:this.right.getheight();

        }


        void preorder(){

            System.out.print(num+" ");

            if(this.left!=null){
                this.left.preorder();
            }

            if(this.right!=null){
                this.right.preorder();
            }

        }

        void inorder(){


            if(this.left!=null){
                this.left.inorder();
            }
            System.out.print(num+" ");
            if(this.right!=null){
                this.right.inorder();
            }
        }

        void postorder(){


            if(this.left!=null){
                this.left.postorder();
            }

            if(this.right!=null){
                this.right.postorder();
            }

            System.out.print(num+" ");
        }


        void add(Node x){

            if(x.num<this.num){
                if(this.left==null)this.left=x;
                else this.left.add(x);
            }else if(x.num>this.num){
                if(this.right==null)this.right=x;
                else this.right.add(x);
            }

            if(getRightHeight()-getLeftHeight()>1){
                leftRotate();
            }

        }

        void leftRotate(){

            Node node = new Node(this.num);

            node.left = this.left;
            node.right=this.right.left;

            this.num = right.num;

            this.right=right.right;

            this.left=node;


        }

        void rightRotate(){

            Node node = new Node(this.num);

            node.right = this.right;
            node.left=this.left.right;

            this.num = left.num;

            this.left=left.left;

            this.right=node;


        }
    }
}
