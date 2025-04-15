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

public class AVLfrmScratch {
    TreeNode root;

    public boolean search ( TreeNode root,int e){
        if ( root == null )return false;
        if ( root.val == e)return true;
        return search(root.left, e) || search(root.right, e);
    }   
    
    public void insert( TreeNode root,int e){
        // in case of LL
        if (){

        }
        root = Rrotate(root);

        //in case of LR
        root.left = Lrotate( root.left);
        root = Rrotate(root);

        // in case of RR
        root = Lrotate(root);
        
        //RL
        root.right = Rrotate(root.right);
        root = Lrotate(root);

    }


    //helper function 
    public static boolean isavltree(TreeNode root){
        if (root == null)return true;

        if ( Math.abs (height(root.left) - height(root.right)) > 1){
            return false;
        }

        return isavltree(root.left) && isavltree(root.right);
    }
    
    private static int height(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        // Return height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }


    //rotation helper functions 
    private TreeNode Rrotate ( TreeNode root){
        //child will be its left child 
        TreeNode c = root.left;
        TreeNode t2 = c.right;
        root.left = t2;
        c.right = root;
        return c;
    }
    private TreeNode Lrotate ( TreeNode root){
        //child to be on right
        TreeNode c = root.right;
        TreeNode t2 = c.left;
        root.right = t2;
        c.left = root;
        return c;
    }

}
