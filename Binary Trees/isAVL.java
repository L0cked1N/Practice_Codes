
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode ( int e){
        this.val = e;
        this.left = null;
        this.right = null;
    }

}
public class isAVL {
    // checking whether the node is balanced or not
    // if all nodes are balanced then automatically it is balanced
    public static boolean isavltree(TreeNode root){
        if (root == null)return true;

        if ( Math.abs (height(root.left) - height(root.right)) > 1){
            return false;
        }

        return isavltree(root.left) && isavltree(root.right);
    }
    
    //this serves as a helper function 
    private static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Return height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    
        public static void main(String[] args) {
            // Create an AVL tree
            TreeNode root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(15);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(7);
    
            // Check if the tree is an AVL tree
            boolean isAVL = isavltree(root);
            System.out.println("Is the tree an AVL Tree? " + isAVL);

            TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.right = new TreeNode(20);
        root2.right.right.right = new TreeNode(25);
        System.out.println("Is the second tree an AVL Tree? " + isavltree(root2));
        
    }
}
