
public class Daimeter
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
        System.out.println(diameter(root).dia);

    }
    static class Node 
    {
        int data ;
        Node left ; 
        Node right;
        public Node(int data)
        {
            this.data = data ;
            this.left = null;
            this.right = null;
        }
    }
    static class Info
    {
        int dia;
        int ht ;
        public Info(int dia , int ht )
        {
            this.dia = dia ;
            this.ht = ht ;
        }
    }
    public static Info diameter(Node root )
    {
        if(root == null )
        {
            return new Info(0,0);
        }
        Info left = diameter(root.left );
        Info right = diameter(root.right  );

        int f_diam = Math.max(Math.max(left.dia , right.dia) , left.ht + right.ht+1);
        int f_height = Math.max(left.ht , right.ht) +1;
        return new Info(f_diam , f_height );
    }
}