package ImportantQ.Tree.BST;
import ImportantQ.Tree.Node.TreeNode;
// Ceil is number in BST which is greatest, smaller number than ceil, present in BST
// we need to return a number in BST which is just greater than ceil
public class CeilBST {
    public  static int findCeil(TreeNode treeNode, int ceil) {

        // Write your code here
        int ans = -1;
        while(treeNode != null){
            if(ceil == treeNode.val){
                ans = treeNode.val;
                break;
            }
            if(ceil > treeNode.val){
                treeNode = treeNode.right;
            }else{
                ans = treeNode.val;
                treeNode = treeNode.left;
            }
        }
        return ans;
    }
}
