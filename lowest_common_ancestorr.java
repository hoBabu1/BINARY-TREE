import java.util.*;
public class lowest_common_ancestorr {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        System.out.println(ancestor1(root , 4 , 7).data);
        System.out.println(ancestor2(root,4 ,3 ).data);
    }
     static class Node
    {
        int data;
        Node right ;
        Node left;
        public Node(int data )
        {
            this.data = data ;
            this.right = null;
            this.left = null;
        }
    }
    public static boolean getPath(Node root , int n , ArrayList<Node> path)
    {
        if(root == null)
        {
            return false ;
        }
        path.add(root);
        if(root.data == n )
        {
            return true;
        }
        boolean found_left = getPath(root.left , n , path);
        boolean found_right = getPath(root.right , n , path);
        if(found_left || found_right)
        {
            return true ;
        }
        else 
        {
            path.remove(path.size()-1);
            return false ;
        }
    }
    public static Node ancestor1(Node root , int n1 , int n2)
    {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root , n1 , path1);
        getPath(root , n2 , path2);
        int i = 0 ;
        for(; i<path1.size() && i<path2.size() ; i++)
        {
            if(path1.get(i) != path2.get(i))
            {
                break;
            }
        }
        Node lca = path2.get(i-1);
        return lca;
    }
    public static Node ancestor2(Node root , int n1 , int n2)
    {
        if(root == null || root.data == n1 || root.data == n2)
        {
            return root;
        }
        Node left = ancestor2(root.left , n1 , n2);
        Node right = ancestor2(root.right, n1 , n2);
        if(right  == null)
        {
            return left ;
        }
        if(left == null)
        {
            return right;
        }
        return root;
    }
     
}

