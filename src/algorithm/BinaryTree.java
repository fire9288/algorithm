package algorithm;

public class BinaryTree {

    public static void main(String[] args) {

        MybinaryTree Tree = new MybinaryTree();

        Tree.root = new Node(1);
        Tree.root.left=new Node(3);
        Tree.root.left.left=new Node(8);
        Tree.root.left.right=new Node(10);


        Tree.root.right=new Node(6);
        Tree.root.right.left=new Node(14);

        Tree.in();
    }


    static class MybinaryTree{

        Node root;
        void pre(){root.preorder();}
        void in(){root.inorder();}
        void post(){root.postorder();}



    }
    static class Node{

         Node left;
         Node right;
         int num;
         public Node(int n){
             this.num = n ;
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

    }
}


