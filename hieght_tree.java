public class hieght_tree
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
        System.out.println(height(root));
        counts(root);
        sum_nodes(root);
        
         System.out.println(count);
         System.out.println(count_nodes(root));
          System.out.println("sum is " + sum);
          System.out.println("sum is " + sum_mentos(root));
          System.out.println(daimeter(root));
    }
    public static int height(Node root)
    {
        if(root == null)
        {
            return 0 ;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh , rh)+1;
    }
    public static class Node 
    {
        int data ;
        Node right;
        Node left;
        public Node(int data )
        {
            this.data = data ;
            this.right = null ;
            this.left = null;
        }
    }
    static int count = 0 ; 

    public static void counts(Node root)
    {
    
        if(root == null)
        {
            return;
        }
        count++;
        counts(root.left);
        counts(root.right);
    }
    public static int  count_nodes(Node root)
    {
        if(root == null)
        {
            return 0 ;
        }

        int lc = count_nodes(root.left);
        int rc = count_nodes(root.right);

        return lc + rc +1;
    }
    static int sum = 0;
    public static void sum_nodes(Node root)
    {
        if(root == null)
        {
            return ;
        }
        sum += root.data;
        sum_nodes(root.left);
        sum_nodes(root.right);
    }

    public static int  sum_mentos(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int lastleft = sum_mentos(root.left);
        int right = sum_mentos(root.right);
        return lastleft + right + root.data;
    }
    public static int  daimeter(Node root)
    {
        if(root == null)
        {
            return 0;
        }
        int leftd = daimeter(root.left);
        int rightd = daimeter(root.right);
        int leftheight =height(root.left);
        int rightheight = height(root.right);

        int self = leftheight+rightheight+1;
        return Math.max(self , Math.max(leftd,rightd));
    }
}