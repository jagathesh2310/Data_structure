package Tree;

class AVLTree{
    Node root;
    class Node{
        int key;
        Node left,right;
        int height;

        public Node(int val){
            key=val;
            left=right=null;
            height=0;
        }

    }
    public int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    public AVLTree(){
        root=null;
    }
    public AVLTree(int val){
        root=new Node(val);
    }
    public Node insert(Node node,int val){

        if(node==null) {
            return new Node(val);
        }
        //System.out.println("llll");
        if (node.key>val) {
            node.left = insert(node.left, val);
        }
        else if(node.key<val){
            node.right=insert(node.right,val);
        }
        else{
            return node;
        }
        node.height=1+max(getHeight(node.left),getHeight(node.right));
//        if(val==40){
//            System.out.println("The height of node "+node.key+" is updated as "+node.height);
//        }
        int balFactor=getBalanceFactor(node);
        //LL case
        if(balFactor>1 && val < node.left.key){
            return rightRotate(node);
        }
        //LR case
        if(balFactor>1 && val>node.left.key){
            node.left=leftRotate(node.left);
            return rightRotate(node);
        }
        //RR case
        if(balFactor<-1 && val > node.right.key){
            return leftRotate(node);
        }
        //RL case
        if(balFactor<-1 && val < node.right.key){
            node.right=rightRotate(node.right);
            leftRotate(node);
        }

        return node;
    }
    private Node rightRotate(Node z){
        Node y=z.left;
        Node t3=y.right;
        y.right=z;
        z.left=t3;
        z.height=1+max(getHeight(z.left),getHeight(z.right));
        y.height=1+max(getHeight(y.left),getHeight(y.right));
        return y;
    }
    private Node leftRotate(Node z){
        Node y=z.right;
        Node t3=y.left;
        y.left=z;
        z.right=t3;
        z.height=1+max(getHeight(z.left),getHeight(z.right));
        y.height=1+max(getHeight(y.left),getHeight(y.right));
        return y;
    }

    public int getBalanceFactor(Node node){
        if (node==null){
            return 0;
        }
        return getHeight(node.left)-getHeight(node.right);
    }
    public int max(int a,int b){
        return a>b?a:b;
    }
    public void insert(int val){
        root=insert(root,val);
        //System.out.println(root.key);
        //System.out.println("kkkkk");
    }
    public void inOrder(Node root){
        if(root!=null) {

            inOrder(root.left);
            System.out.println(root.key+" height is "+root.height);
            inOrder(root.right);
        }
    }
    public Node search(Node root,int val){
        if(root.key==val || root==null){
            return root;
        }
        if(val<root.key){
            return search(root.left,val);
        }

        return search(root.right,val);

    }
    public Node delete(Node root,int val){
        if(root==null){
            return root;
        }
        if(val<root.key){
            root.left=delete(root.left,val);
        }
        else if(val>root.key){
            root.right=delete(root.right,val);
        }
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            root.key=  min(root.right);
            root.right=delete(root.right,root.key);
        }
        return root;
    }
    public int min(Node root){
        int minVal=root.key;
        while (root.left!=null){
            minVal= root.left.key;
            root=root.left;
        }
        return minVal;

    }

}

public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree tree=new AVLTree(50);
        //tree.insert(50);
        tree.insert(20);//
        tree.insert(60);
        tree.insert(10);//
        tree.insert(30);//
        tree.insert(40);//
//        tree.insert(90);
        tree.inOrder(tree.root);

    }
}
