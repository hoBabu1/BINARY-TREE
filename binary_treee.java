import java.util.*;
public class Binary_treee
{
    public static void main(String args[])
    {
        int arr[] ={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree bt =   new BinaryTree();
        Node root = bt.build_preorder(arr);
        // System.out.println(root.data);
        // preorder(root);
        // System.out.println();
        // ineorder(root);
        // System.out.println();
        // postorder(root);
        level_order(root);

    }
    public static class Node{
        int data;
        Node left ;
        Node right;
        public Node(int data )
        {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    public static class BinaryTree{
        static int indx = -1;
        public static Node build_preorder(int arr[])
        {
            indx++;
            if(arr[indx]==-1)
            {
                return null ;
            }
            // create node 
            Node newNode = new Node(arr[indx]);
            newNode.left = build_preorder(arr);
            newNode.right = build_preorder(arr);
            return newNode;
        }
    }
    public static void preorder(Node root)
    {
        if(root == null )
        {
            return ;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
     public static void ineorder(Node root)
    {
        if(root == null )
        {
            return ;
        }
        
        ineorder(root.left);
        System.out.print(root.data+" ");
        ineorder(root.right);
    }
    public static void postorder(Node root)
    {
        
        if(root == null )
        {
            return ;
        }
        
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void level_order(Node root)
    {
        if(root == null )
        {
            return;
        }
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
                System.out.print(curr.data +" ");
                if(curr.left != null)
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

}
