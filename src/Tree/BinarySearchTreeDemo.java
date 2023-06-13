package Tree;

class BinarySearchTree{
    Node root;
    class Node{
        int key;
        Node left,right;

        public Node(int val){
            key=val;
            left=right=null;
        }
    }
    public BinarySearchTree(int val){
        root=new Node(val);
    }
    public Node insert(Node root,int val){
        if(root==null) {
            return new Node(val);
        }
        if (root.key>val) {
            root.left = insert(root.left, val);
        }
        else{
            root.right=insert(root.right,val);
        }
        return root;
    }
    public void insert(int val){
        insert(root,val);
    }
    public void inOrder(Node root){
        if(root!=null) {

            inOrder(root.left);
            System.out.print(root.key+" ");
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

public class BinarySearchTreeDemo {
    public static void main(String[] args) {
        BinarySearchTree tree=new BinarySearchTree(50);
        tree.insert(20);
        tree.insert(70);
        tree.insert(10);
        tree.insert(25);
        tree.insert(60);
        tree.insert(90);
        tree.inOrder(tree.root);
        System.out.println();
        System.out.println(tree.search(tree.root, 70).key);
        tree.delete(tree.root, 20);
        tree.inOrder(tree.root);
    }
}
