//breadth first traversal java
import java.util.LinkedList;
import java.util.Queue;
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
public class BFS {
    public static void BFtraversal ( TreeNode root){
        if ( root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while ( !q.isEmpty()){
            TreeNode curr = q.poll();
            System.out.println(curr.val);
            if ( curr.left!= null)q.offer(curr.left);
            if (curr.right!= null)q.offer(curr.right);
        }
        return;
    }
    public static void main (String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BFtraversal(root);
    }
}
