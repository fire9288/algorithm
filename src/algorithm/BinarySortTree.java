package algorithm;

public class BinarySortTree {

    public static void main(String[] args) {


        int arr[]={3,7,10,12,5,1,9};
        MyTree myTree = new MyTree();


        for (int i : arr) {
            myTree.add(new node(i));
        }

        myTree.inorder();
    }


    static class MyTree{

        node root;


        public void add(node x){
            if(root==null)root=x;
            root.add(x);
        }

        public void inorder(){
            root.inorder();
        }

    }
    static class node{

        int value;
        node left;
        node right;

        public node(int i){this.value=i;}

        void add(node x){

            if(x.value<this.value){
                if(this.left==null)this.left=x;
                else this.left.add(x);
            }else if(x.value>this.value){
                if(this.right==null)this.right=x;
                else this.right.add(x);
            }



        }

        void inorder(){

            if(this.left!=null)this.left.inorder();
            System.out.println(this.value);
            if(this.right!=null)this.right.inorder();
        }
    }
}
