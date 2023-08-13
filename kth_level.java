
public class kth_level {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        k_level(root , 2 , 1);
    }
    static class Node{
        int data ; 
        Node right ;
        Node left ;
        public Node(int data )
        {
            this.data = data;
            this.left = null ;
            this.right = null;
        }
    }
    public static void k_level(Node root , int k , int cl)
    {
        if(root == null)
        {
            return ; 
        }
        if(k == cl )
        {
            System.out.print(root.data+" ");
            return;
        }
        k_level(root.left , k , cl+1);
        k_level(root.right , k , cl+1);
    }
    
}
