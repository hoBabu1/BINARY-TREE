// 1-->find sub root  2 --> check wether it is identical or not 
public class subtree
{
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);
        System.out.println(Subtree(root , subroot));

    }
    static class Node 
    {
        int data ; 
        Node left ;
        Node right ;
        public Node(int data )
        {
            this.data = data ;
            this.left = null;
            this.right = null;
        }
    }
    public static boolean Subtree(Node root , Node subroot)
    {
        // base case 
        if(root== null)
        {
            return false ;
        }

        if(root.data == subroot.data)
        {
            if(isidentical(root , subroot))
            {
                return true ;
            }
        }
        return  Subtree(root.left, subroot) || Subtree(root.right , subroot);
    }
    public static boolean isidentical(Node root , Node subroot)
    {
        if(root == null && subroot == null )
        {
            return true ;
        }
        else if(root == null || subroot == null || root.data != subroot.data )
        {
            return false ;
        }
        if(!isidentical(root.left , subroot.left ))
        {
            return false ;
        }
        if(!isidentical(root.right , subroot.right ))
        {
            return false ;
        }
        return true  ;
    }
     
}