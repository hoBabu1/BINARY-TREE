import java.util.*;
public class top_view_of_a_tree {
    public static void main(String args[])
    {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Top_view(root);
    }
    static class Node 
    {
        Node right ;
        Node left;
        int data ;
        public Node(int data)
        {
            this.data = data ;
            this .right = null ;
            this.left = null;
        }
    }
    static class Info{
        Node node ;
        int hd ;
        public Info(int hd , Node node)
        {
            this.hd = hd ;
            this.node = node;
        }
    }
    public static void Top_view(Node root)
    {
        int min = 0 ;
        int max = 0 ;
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer , Node> map = new HashMap<>();
        q.add(new Info(0 , root));
        q.add(null);
        while(!q.isEmpty())
        {
            Info curr = q.remove();
            if(curr == null)
            {
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
                if(!map.containsKey(curr.hd))
                {
                    map.put(curr.hd  , curr.node);
                }
                if(curr.node.left != null)
                {
                    q.add(new Info(curr.hd-1,curr.node.left));
                    min = Math.min(min , curr.hd-1 );

                }
                 if(curr.node.right != null)
                {
                    q.add(new Info(curr.hd+1,curr.node.right));
                    max = Math.max(max,curr.hd+1);
                }

            }

        }
        for(int i = min ; i<= max ; i++)
        {
            System.out.print(map.get(i).data+" ");
        }
    }
}
