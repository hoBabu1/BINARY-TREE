import java.util.*;
public class lets_go {
    public static void main(String args[])
    {
        int arr[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root = null;
         BinarTreee bt = new BinarTreee();
          root = bt.build(arr);
          System.out.println("predorder traversal is --->");
          preorder(root);
          System.out.println();
           System.out.println("inorder traversal is --->");
          inorder(root);
          System.out.println();
          System.out.println("levelorder traversal is --->");
          level_order(root);
          System.out.println(height(root , 0));
          Info diam = diameter(root);
          System.out.println("diameter is "+diam.diameter);
    }
    
    public static class Node 
    {
        int data ; 
        Node right ;
        Node left ;
        public Node(int data)
        {
            this.data = data ;
            this.right = null;
            this.left = null;
        }
    }
    static int  i = -1;
    public static class BinarTreee
    {
        public static Node build(int arr[])
        {
            i++;
            if(arr[i] == -1)
            {
                return null;
            }
            Node newnode = new Node(arr[i]);
            newnode.left = build(arr);
            newnode.right = build(arr);
            return newnode;

        }
    }
    public static void preorder(Node root)
    {
        if(root == null)
        {
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
 
    }
     public static void inorder(Node root)
    {
        if(root == null)
        {
            return ;
        }
        
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);    
    } 
    public static void level_order(Node root )
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty())
        {
           Node curr = q.remove();
           if(curr == null)
           {
            System.out.println();
            if(q.isEmpty())
            {
                break;
            }
            else 
            {
                q.add(null);
            }
           }
           else 
           {
            System.out.print(curr.data+" ");
            if(curr.left!= null)
            {
                q.add(curr.left);
            }
            if(curr.right != null)
            {
                q.add(curr.right);
            }
           }
        }
    }
    public static int height(Node root , int max )
    {
        if(root == null)
        {
            return 0;
        }
        int left = height(root.left , max );
        int right = height(root.right , max );
        max  = Math.max(left , right )+1;
        return max;
        
    }
    public static class Info
    {
        int diameter ;
        int height;
        public Info(int diameter , int height)
        {
            this.diameter= diameter;
            this.height = height;
        }
    }
    public static Info diameter(Node root)
    {
        if(root == null)
        {
            return new Info(0,0);
        }
        Info Info_left = diameter(root.left);
        Info Info_right = diameter(root.right);
        int fdia = Math.max(Info_left.height+Info_right.height+1 , Math.max(Info_left.height,Info_right.height));
        int fheight = Math.max(Info_left.height,Info_right.height)+1;
        return new Info(fdia , fheight);
    }
}
