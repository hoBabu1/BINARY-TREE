public class kth_ancestor_node {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        kth(root , 1 , 4);
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
    public static int   kth(Node root , int k , int n )
    {
        if(root == null)
        {
            return -1;
        }
        if(root.data == n)
        {
            return 0;
        }
        int  left = kth(root.left , k , n );
        int  right = kth(root.right,k , n);
        if( left == -1 && right == -1)
        {
            return -1;
        }
        int max = Math.max(left , right);
        if( max +1 == k)
        {
            System.out.println(root.data);
        }
        return max+1;
    }
    
}
