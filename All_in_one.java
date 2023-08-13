import java.util.*;
public class All_in_one
{
    public static void main(String args[])
    {
        int nodes[]= {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.build(nodes);
        //System.out.println(root.data);
        Level_order(root);
    }
    static class Node 
    {
        int data ;
        Node right ;
        Node left ; 
        public Node(int data )
        {
            this.data = data ;
            this.right = null ;
            this.left = null;
        }
    }
    public static class BinaryTree{
        static int idx = -1;
        public static Node build(int nodes[])
        {
            idx++;
            if(nodes[idx]==-1)
            {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = build(nodes);
            newnode.right = build(nodes);
            return newnode;

        }
    }
    public static void Level_order(Node root )
    {
        if(root == null )
        {
            return;
        }
        Queue<Node> collect = new LinkedList<>();
        collect.add(root);
        collect.add(null);
        System.out.println(root.data);
        Node curr2 = root;
        while(!collect.isEmpty())
        {
            
            Node curr = collect.remove();
            if(curr == null)
            {
                //System.out.println();
                
                if(collect.isEmpty())
                {
                    break;
                }
                else 
                {
                    collect.add(null);
                    System.out.println(curr2.data);
                }
            }
            else 
            {
                //System.out.print(curr.data+" ");
                
                if(curr.left != null )
                {
                    collect.add(curr.left);
                }
                if(curr.right != null)
                {
                    collect.add(curr.right);
                    curr2 = curr.right;
                }
            }
        }
    }
}
