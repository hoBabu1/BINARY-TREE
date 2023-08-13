

public class minimum_distance_btw_nodes {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(minimum(root,5 , 4));
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
    public static Node LCA(Node root , int n1 , int n2 )
    {
        if(root == null || root.data == n1 || root.data == n2 )
        {
            return root;
        }
        Node left = LCA(root.left , n1 , n2);
        Node right = LCA(root.right , n1 , n2);
        if(right == null )
        {
            return left ;
        }
        if(left == null)
        {
            return right ;
        }
        return root;
    }
    public static int minimum(Node root , int n1 , int n2 )
    {
        Node lca = LCA(root , n1 ,n2);
        // distance betwwen n1 to lca 
        int n11 = distance(lca , n1);
        
        // distance betwwenlca to n2 
        int n22 = distance(lca , n2);
        return n11+n22;

    }
    public static int distance(Node root , int n)
    {
        if(root == null )
        {
            return -1 ;
        }
        if(root.data == n)
        {
            return 0;
        }
        int  left = distance(root.left , n );
        int  right = distance(root.right , n );
        if(left == -1 && right == -1)
        {
            return -1;
        }
        else if(left == -1 )
        {
            return right +1;
        }
        else 
        {
            return left +1 ;
        }
        
    }
}
