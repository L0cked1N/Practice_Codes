class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode ( int e){
        this.val = e;
        this.right = null;
        this.left = null;
    }
}
public class DFS {
    public static void PostOrder(TreeNode root){
        if ( root == null)return;
        // left -> right -> root
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.val);
        
    }
    public static void Preorder ( TreeNode root){
        if ( root == null)return;
        // root -> left -> right
        System.out.println(root.val);
        Preorder(root.left);
        Preorder(root.right);
        
    }
    public static void Inorder(TreeNode root){
        if ( root == null)return;
        // left ->root -> right
        Inorder(root.left);
        System.out.println(root.val);
        Inorder(root.right);
    }
    public static void main (String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        //DFtraversal(root);
        PostOrder(root);
        System.out.println("->");
        Preorder(root);
        System.out.println("->");
        Inorder(root);

    }
}
