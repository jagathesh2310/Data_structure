package Tree;

class BinaryTree{
    Node root;
    public BinaryTree(int d){
        root=new Node(d);
    }
    public void insertLeft(Node r,int val){
        Node newNode=new Node(val);
        r.left=newNode;
    }
    public void insertRight(Node r,int val){
        Node newNode=new Node(val);
        r.right=newNode;
    }
    public static void preOrder(Node root){
        if(root!=null) {
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public static void inOrder(Node root){
        if(root!=null) {

            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }
    public static void postOrder(Node root){
        if(root!=null) {

            postOrder(root.left);

            postOrder(root.right);
            System.out.print(root.data+" ");

        }
    }

    class Node{
        int data;
        Node left,right;
        public Node(int d){
            data=d;
            left=null;
            right=null;
        }
    }
}
public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree=new BinaryTree(10);
        tree.insertLeft(tree.root,5);
        tree.insertRight(tree.root,15);
        tree.insertLeft(tree.root.left,3 );
        tree.insertRight(tree.root.left,8 );
        tree.insertLeft(tree.root.right,12);
        BinaryTree.preOrder(tree.root);
        System.out.println();
        BinaryTree.inOrder(tree.root);
        System.out.println();
        BinaryTree.postOrder(tree.root);

    }

}
